import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {DashboardComponent} from './components/dashboard/dashboard.component';

@Component({
  selector: 'app-root',
  imports: [DashboardComponent, RouterOutlet],
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
