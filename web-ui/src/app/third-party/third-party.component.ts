import {Component, OnInit, ViewChild} from '@angular/core';
import {AnimalDto, AnimalRestEndpointService, ThirdPartyRestEndpointService} from '../../generated';
import {AddAnimalDto} from "../../generated/model/addAnimalDto";
import {MatDialog, MatPaginator, MatSort, MatTableDataSource} from "@angular/material";
import {ModalMessageWindowComponent} from "../modal-message-window/modal-message-window.component";
import ExternalStatusEnum = AnimalDto.ExternalStatusEnum;

export interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'third-party',
  templateUrl: './third-party.component.html',
  styleUrls: ['./third-party.component.css']
})
export class ThirdPartyComponent implements OnInit {
  displayedColumns: string[] = ['name', 'source', 'externalStatus', 'internalStatus', 'actions'];
  dataSource: MatTableDataSource<AnimalDto>;
  thirdPartyRestEndpointService: ThirdPartyRestEndpointService;
  animalRestEndpointService: AnimalRestEndpointService;

  color = 'primary';
  mode = 'indeterminate';
  value = 50;
  displayProgressSpinner = false;
  spinnerWithoutBackdrop = false;

  externalStatuses = AnimalDto.ExternalStatusEnum;
  selectedExternalStatus: ExternalStatusEnum = ExternalStatusEnum.Pending;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(thirdPartyRestEndpointService: ThirdPartyRestEndpointService,
              animalRestEndpointService: AnimalRestEndpointService,
              public dialog: MatDialog) {
    this.thirdPartyRestEndpointService = thirdPartyRestEndpointService;
    this.animalRestEndpointService = animalRestEndpointService;
  }

  ngOnInit(): void {
    this.getThirdPartyAnimals();
  }

  onExternalStatusSelection() {
    this.getThirdPartyAnimals();
  }

  private getThirdPartyAnimals() {
    this.showProgressSpinner();
    this.thirdPartyRestEndpointService
    .findThirdPartyAnimalByStatus(this.selectedExternalStatus)
    .subscribe(resultArray => {
        this.dataSource = new MatTableDataSource<AnimalDto>(resultArray);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      },
      error => {
        this.openDialog({
          success: false,
          title: "Failed loading Third Party animals",
          errorMessage: "Error: " + error.statusText + " " + error.status
        })
        console.log("Error :: " + error);
      }).add(() => {
      this.hideProgressSpinner();
    });
  }

  importIntoAnimalSuperStore(id, name, source) {
    const addAnimalDto: AddAnimalDto = {} as AddAnimalDto;
    addAnimalDto.id = id;
    addAnimalDto.source = source;
    this.showProgressSpinner();
    this.animalRestEndpointService.addAnimal(addAnimalDto)
    .subscribe(
      data => {
        this.openDialog({
          success: true,
          title: "Successfully imported",
          id: id,
          name: name,
          source: source
        })
      },
      error => {
        console.log(error)
        this.openDialog({
          success: false,
          title: "Failed importing",
          id: id,
          name: name,
          source: source,
          errorMessage: "Error: " + error.statusText + " " + error.status
        })
      }).add(() => {
      this.hideProgressSpinner();
    });
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


