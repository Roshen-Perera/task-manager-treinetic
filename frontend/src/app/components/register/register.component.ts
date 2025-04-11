import {Component, OnInit} from '@angular/core';
import {UserService} from '../../service/user.service';
import {RouterLink} from '@angular/router';
import {User} from '../../model/user';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

    username = '';
    password = '';

  constructor(private userService: UserService) {
  }

    userObject : User = new User();
    ngOnInit(): void {
      this.userObject = new User();
    }



  registerUser() {
    const formData = new FormData();
    formData.append('username', this.username);
    formData.append('password', this.password);

    this.userService.registerUser(formData).subscribe(
      res => {
        console.log(res);
      },
      err => {
        console.error(err);
        const message = err?.error?.message || 'Something went wrong';
        alert(message);
      }
    );
  }


}
