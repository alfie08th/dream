import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CarListComponent} from './car-list/car-list.component';
import {Routes} from '@angular/router';
import { MicroserviceComponent } from './microservice/microservice.component';

const routes: Routes = [
  {path: '', component: CarListComponent},
  {path: '', component: CarListComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    MicroserviceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
