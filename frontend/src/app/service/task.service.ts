import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  serviceURL : string ;

  constructor(private http: HttpClient) {
    this.serviceURL = "http://localhost:8080/trienetic/api/task"
  }
}
