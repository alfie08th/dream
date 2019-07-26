import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {CarListComponent} from './car-list/car-list.component';
import {RouterModule, Routes} from '@angular/router';
import { MicroserviceComponent } from './microservice/microservice.component';
import { LoginComponent } from './login/login.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";

const routes: Routes = [
  // {path: '', component: AppComponent, data: {animation: 'isLeft'}},
  // {path: 'car-list', component: CarListComponent, data: {animation: 'isLeft'}},
  // {path: 'login', component: LoginComponent, data: {animation: 'isLeft'}},
  // {path: 'service', component: MicroserviceComponent, data: {animation: 'isLeft'}}

  {path: '', component: AppComponent, data: {animation: 'fader'}},
  {path: 'car-list', component: CarListComponent, data: {animation: 'fader'}},
  {path: 'login', component: LoginComponent, data: {animation: 'fader'}},
  {path: 'service', component: MicroserviceComponent, data: {animation: 'fader'}}
];
@NgModule({
  declarations: [
    AppComponent,
    CarListComponent,
    MicroserviceComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
