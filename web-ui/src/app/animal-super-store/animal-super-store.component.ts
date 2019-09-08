import {Component, OnInit, ViewChild} from '@angular/core';
import {AnimalDto, AnimalRestEndpointService} from '../../generated';
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ModalMessageWindowComponent} from "../modal-message-window/modal-message-window.component";

@Component({
  selector: 'animal-super-store',
  templateUrl: './animal-super-store.component.html',
  styleUrls: ['./animal-super-store.component.css']
})
export class AnimalSuperStoreComponent implements OnInit {
  displayedColumns: string[] = ['name', 'source', 'externalStatus', 'internalStatus'];
  dataSource: MatTableDataSource<AnimalDto>;
  animalRestEndpointService: AnimalRestEndpointService;

  color = 'primary';
  mode = 'indeterminate';
  value = 50;
  displayProgressSpinner = false;
  spinnerWithoutBackdrop = false;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(animalRestEndpointService: AnimalRestEndpointService,
              public dialog: MatDialog) {
    this.animalRestEndpointService = animalRestEndpointService;
  }

  ngOnInit(): void {
    this.showProgressSpinner();
    this.animalRestEndpointService.getAllAnimals()
    .subscribe(
      resultArray => {
        this.dataSource = new MatTableDataSource<AnimalDto>(resultArray);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => {
        this.openDialog({
          success: false,
          title: "Failed loading Animal Super Store animals",
          errorMessage: "Error: " + error.statusText + " " + error.status
        })
        console.log("Error :: " + error)
      })
    .add(() => {
      this.hideProgressSpinner();
    });
    ;
  }

  openDialog(animalData) {
    this.dialog.open(ModalMessageWindowComponent, {data: animalData});
  }

  showProgressSpinner = () => {
    this.displayProgressSpinner = true;
  }

  hideProgressSpinner = () => {
    this.displayProgressSpinner = false;
  }

  showSpinnerWithoutBackdrop = () => {
    this.spinnerWithoutBackdrop = true;
  }

  hideSpinnerWithoutBackdrop = () => {
    this.spinnerWithoutBackdrop = false;
  }
}
