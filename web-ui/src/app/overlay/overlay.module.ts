import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OverlayService, AppOverlayConfig} from "./overlay.service";
import {OverlayModule} from "@angular/cdk/overlay";
export { OverlayService, AppOverlayConfig } from './overlay.service';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    OverlayModule
  ],
  providers: [OverlayService]
})
export class AppOverlayModule { }
