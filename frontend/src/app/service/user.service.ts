import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {User} from '../model/user';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  serviceURL : string

  constructor(private http: HttpClient) {
    this.serviceURL = "http://localhost:8080/trienetic/api/auth"
  }

  registerUser(userData: FormData): Observable<any> {
    return this.http.post(this.serviceURL + '/signup', userData);
  }

  loginUser(user: User): Observable<User> {
    return this.http.post<User>(this.serviceURL + '/signIn', user);
  }
}
