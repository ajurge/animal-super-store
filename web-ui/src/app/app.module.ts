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
import {MatButtonModule, MatDialogModule, MatTableModule, MatTabsModule} from "@angular/material";
import {ModalMessageWindow, Table1Component} from './table1/table1.component';
import {Table2Component} from './table2/table2.component';

@NgModule({
  entryComponents: [AppComponent, ModalMessageWindow],
  declarations: [
    AppComponent,
    Table1Component,
    Table2Component,
    ModalMessageWindow,
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
    MatDialogModule
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
