import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {CarListComponent} from "./car-list/car-list.component";
import {LoginComponent} from "./login/login.component";
import {MicroserviceComponent} from "./microservice/microservice.component";
import {ErrorComponent} from "./error/error.component";

const routes: Routes = [
  {path: 'car-list', component: CarListComponent, data: {state: 'car-list'}},
  {path: 'login', component: LoginComponent, data: {state: 'login'}},
  {path: 'service', component: MicroserviceComponent, data: {state: 'service'}},
  {path: '**', component: ErrorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes, {
    useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
