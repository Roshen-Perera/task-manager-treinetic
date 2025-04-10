import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Task} from '../model/task';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  serviceURL : string ;

  constructor(private http: HttpClient) {
    this.serviceURL = "http://localhost:8080/trienetic/api/task"
  }

  addTask(task: Task): Observable<Task> {
    const headers = new HttpHeaders({
      'Authorization': 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb3NoZW4iLCJpYXQiOjE3NDQyOTYzOTYsImV4cCI6MTc0NDM4Mjc5Nn0.00q3wmyZiORg1y_RPC-q2hJo1ODOKANJIHtMXWF7TQI',  // Example of adding an authorization token
    });

    return this.http.post<Task>(this.serviceURL, task, { headers });
  }
  getTask(): Observable<Task[]> {
    const headers = new HttpHeaders({
      'Authorization': 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb3NoZW4iLCJpYXQiOjE3NDQyOTYzOTYsImV4cCI6MTc0NDM4Mjc5Nn0.00q3wmyZiORg1y_RPC-q2hJo1ODOKANJIHtMXWF7TQI',  // Example of adding an authorization token
    });
    return this.http.get<Task[]>(this.serviceURL, { headers });
  }

  deleteTask(task: Task): Observable<Task> {
    const headers = new HttpHeaders({
      'Authorization': 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb3NoZW4iLCJpYXQiOjE3NDQyOTYzOTYsImV4cCI6MTc0NDM4Mjc5Nn0.00q3wmyZiORg1y_RPC-q2hJo1ODOKANJIHtMXWF7TQI',  // Example of adding an authorization token
    });
    return this.http.get<Task>(this.serviceURL+'/'+task.id, { headers });
  }

}
