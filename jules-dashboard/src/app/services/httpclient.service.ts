import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


export class MicroService {
  constructor(
    public serviceId: string,
    public serviceName: string,
    public serviceUrl: string,
    public latestBuild: string,
    public lastBuild: string) {}
}

@Injectable({
  providedIn: 'root'
})


export class HttpclientService {

  constructor(private httpClient: HttpClient) {}
  getMicroServices() {
    return this.httpClient.get<MicroService[]>('http://localhost:8080/service');
  }
}
