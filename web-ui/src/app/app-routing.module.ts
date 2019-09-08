import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {ThirdPartyComponent} from "./third-party/third-party.component";
import {AnimalSuperStoreComponent} from "./animal-super-store/animal-super-store.component";

const routes: Routes = [
  { path: '', redirectTo: '/third-party', pathMatch: 'full' },
  { path: 'third-party', component:  ThirdPartyComponent},
  { path: 'animal-super-store', component:  AnimalSuperStoreComponent}
];
export const appRouting = RouterModule.forRoot(routes);
@NgModule({
  imports: [
    RouterModule.forRoot(routes),
    CommonModule
  ],
  exports: [ RouterModule ],
  declarations: []
})
export class AppRoutingModule { }
