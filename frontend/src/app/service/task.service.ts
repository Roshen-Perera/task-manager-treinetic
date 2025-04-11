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
    const token = localStorage.getItem('token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.post<Task>(this.serviceURL, task, { headers });
  }
  getTask(): Observable<Task[]> {
    const token = localStorage.getItem('token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.get<Task[]>(this.serviceURL, { headers });
  }

  deleteTask(id: number): Observable<Task> {
    const token = localStorage.getItem('token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.delete<Task>(this.serviceURL+'/'+id, { headers });
  }

  updateTask(task: Task): Observable<Task> {
    const token = localStorage.getItem('token')
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
    });
    return this.http.put<Task>(this.serviceURL+'/'+task.id, task, { headers });
  }

}
