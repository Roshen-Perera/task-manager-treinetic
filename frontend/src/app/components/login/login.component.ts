import {Component, OnInit} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {UserService} from '../../service/user.service';
import {User} from '../../model/user';
import {FormsModule} from '@angular/forms';
import {routes} from '../../app.routes';

@Component({
  selector: 'app-login',
  imports: [
    RouterLink,
    FormsModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';

  constructor(private userService: UserService, private router: Router) {
  }

  userObject : User = new User();
  ngOnInit(): void {
    this.userObject = new User();
  }



  loginUser() {
    this.userObject.username = this.username;
    this.userObject.password = this.password;
    this.userService.loginUser(this.userObject).subscribe(
      res => {
        console.log(res);
        localStorage.setItem('token', res.token);
        this.router.navigate(['dashboard']);
      },
      err => {
        console.error(err);
        const message = err?.error?.message || 'Something went wrong';
        alert(message);
      }
    );
  }

  
}
