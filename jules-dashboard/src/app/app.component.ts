import { Component } from '@angular/core';
import {routerTransition} from "./animations/route-animation";

export class App{

}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  animations: [routerTransition]

})
export class AppComponent {
  title = 'jules-dashboard';


  ngOnInit() {
  }

  getState(outlet) {
    return outlet.activatedRouteData.state;
  }
}
