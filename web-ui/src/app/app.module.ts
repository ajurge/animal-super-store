import {BrowserModule} from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ModuleWithProviders, NgModule, Optional, SkipSelf} from '@angular/core';
import {BASE_PATH} from '../generated/variables';
import {environment} from '../environments/environment';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AppComponent} from './app.component';
import {
  AnimalRestEndpointService,
  Configuration,
  ThirdPartyRestEndpointService
} from "../generated";
import {
  MatButtonModule,
  MatCardModule,
  MatDialogModule, MatFormFieldModule,
  MatIconModule,
  MatPaginatorModule, MatSelectModule, MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule
} from "@angular/material";
import {ThirdPartyComponent} from './third-party/third-party.component';
import {AnimalSuperStoreComponent} from './animal-super-store/animal-super-store.component';
import {AppRoutingModule} from './app-routing.module';
import {AppOverlayModule} from "./overlay/overlay.module";
import {ProgressSpinnerModule} from "./progress-spinner/progress-spinner.module";
import {ProgressSpinnerComponent} from "./progress-spinner/progress-spinner.component";
import {ModalMessageWindowComponent} from './modal-message-window/modal-message-window.component';

@NgModule({
  entryComponents: [
    AppComponent,
    ModalMessageWindowComponent,
    ProgressSpinnerComponent,
  ],
  declarations: [
    AppComponent,
    AnimalSuperStoreComponent,
    ModalMessageWindowComponent,
    ThirdPartyComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatTableModule,
    MatTabsModule,
    MatButtonModule,
    MatDialogModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    AppOverlayModule,
    ProgressSpinnerModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatSelectModule
  ],
  providers: [{provide: BASE_PATH, useValue: environment.API_BASE_PATH}, AnimalRestEndpointService,
    ThirdPartyRestEndpointService],
  bootstrap: [AppComponent]
})
export class AppModule {
  public static forRoot(configurationFactory: () => Configuration): ModuleWithProviders {
    return {
      ngModule: AppModule,
      providers: [{provide: Configuration, useFactory: configurationFactory}]
    };
  }

  constructor(@Optional() @SkipSelf() parentModule: AppModule,
              @Optional() http: HttpClient) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
    }
    if (!http) {
      throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
        'See also https://github.com/angular/angular/issues/20575');
    }
  }
}
