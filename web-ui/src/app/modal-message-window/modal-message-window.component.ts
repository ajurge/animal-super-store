import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-modal-message-window',
  templateUrl: './modal-message-window.component.html',
  styleUrls: ['./modal-message-window.component.css']
})
export class ModalMessageWindowComponent {

  constructor(public dialogRef: MatDialogRef<ModalMessageWindowComponent>,
              @Inject(MAT_DIALOG_DATA) public modalMessageData: any) {
  }

  closeDialog() {
    this.dialogRef.close();
  }

}
