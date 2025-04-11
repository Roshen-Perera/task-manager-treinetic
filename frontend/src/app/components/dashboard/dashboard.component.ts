import {Component, OnInit} from '@angular/core';
import {TaskService} from '../../service/task.service';
import {Task} from '../../model/task';
import {FormsModule} from '@angular/forms';
import {CommonModule, DatePipe} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dashboard',

  imports: [
    FormsModule,
    CommonModule
  ],
  providers: [DatePipe],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{


  taskObject : Task = new Task();
  taskList : Task[] = [];
  currentDate: string | null = '';
  currentStatus: string  = 'PENDING';

  time: number = new Date().getTime();

  taskTitle = '';
  taskDescription = '';

  ngOnInit(): void {
    this.currentDate = this.date.transform(new Date(), 'yyyy-MM-dd');
    this.taskObject = new Task();
    this.taskList = [];
    this.loadAllTask();
  }

  loadAllTask() {
    this.taskService.getTask().subscribe(res => {
      this.taskList = res
    }, err => {
      alert("Unable to load task");
    })
  }

  addTask() {
    this.taskObject.id = this.time;
    this.taskObject.title = this.taskTitle;
    this.taskObject.status = this.currentStatus;
    this.taskObject.createdAt = this.currentDate;
    this.taskObject.description = this.taskDescription;

    console.log(this.taskObject);

    this.taskService.addTask(this.taskObject).subscribe(res => {
      this.ngOnInit()
      this.taskTitle = '';
    }, err => {
      alert(err.error.message);
    });
  }

  updateTask() {
    this.taskService.updateTask(this.taskObject).subscribe(res => {
      this.ngOnInit()
    }, err => {
      alert("Failed to update task");
    });
  }

  deleteTask(id: number) {
    this.taskService.deleteTask(id).subscribe(res => {
      console.log("id"+id);
      this.ngOnInit()
    }, err => {
      alert("Failed to delete task");
    });
  }

  logout(): void {
    localStorage.removeItem('token');
    this.router.navigate(['']);
  }

  constructor(private taskService: TaskService, private date: DatePipe, private router: Router) {

  }
}
