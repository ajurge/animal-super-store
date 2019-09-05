import {Component, Inject, OnInit} from '@angular/core';
import {AnimalDto, AnimalRestEndpointService, ThirdPartyRestEndpointService} from '../../generated';
import {AddAnimalDto} from "../../generated/model/addAnimalDto";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material";

export interface DialogData {
  animal: 'panda' | 'unicorn' | 'lion';
}

@Component({
  selector: 'table-1',
  templateUrl: './table1.component.html',
  styleUrls: ['./table1.component.css']
})
export class Table1Component implements OnInit {
  displayedColumns: string[] = ['name', 'source', 'externalStatus', 'internalStatus', 'actions'];
  dataSource: AnimalDto[] = [];
  thirdPartyRestEndpointService: ThirdPartyRestEndpointService;
  animalRestEndpointService: AnimalRestEndpointService;

  constructor(thirdPartyRestEndpointService: ThirdPartyRestEndpointService,
              animalRestEndpointService: AnimalRestEndpointService,
              public dialog: MatDialog) {
    this.thirdPartyRestEndpointService = thirdPartyRestEndpointService;
    this.animalRestEndpointService = animalRestEndpointService;
  }

  ngOnInit(): void {
    this.thirdPartyRestEndpointService
    .findThirdPartyAnimalByStatus('pending')
    .subscribe(resultArray => this.dataSource = resultArray,
      error => console.log("Error :: " + error))
  }

  importIntoAnimalSuperStore(id, name, source) {
    const addAnimalDto: AddAnimalDto = {} as AddAnimalDto;
    addAnimalDto.id = id;
    addAnimalDto.source = source;

    this.animalRestEndpointService.addAnimal(addAnimalDto)
    .subscribe(data => this.openDialog({
        title: "Successfully imported",
        id: id,
        name: name,
        source: source
      }),
      error => {
        this.openDialog({title: "Failed importing", id: id, name: name, source: source})
      })
  }

  openDialog(animalData) {
    this.dialog.open(ModalMessageWindow, {data: animalData});
  }
}

@Component({
  selector: 'modal-message-window',
  templateUrl: 'modal-message-window.html',
})
export class ModalMessageWindow {
  constructor(public dialogRef: MatDialogRef<ModalMessageWindow>,
              @Inject(MAT_DIALOG_DATA) public modalMessageData: any) {
  }

  closeDialog() {
    this.dialogRef.close();
  }
}


