import {Component, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';
import {User} from '../../model/user';

@Component({
  selector: 'app-register',
  imports: [
    RouterLink
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

    username = '';
    password = '';

    userObject : User = new User();
    ngOnInit(): void {
      this.userObject = new User();
    }

    registerUser() {
      this.userObject.username = this.username;
      this.userObject.password = this.password;
    }

}
