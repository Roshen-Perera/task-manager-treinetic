import {Component, OnInit} from '@angular/core';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [
    RouterLink
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit{

  taskObject : Task = new Task();
    ngOnInit(): void {

    }

}
