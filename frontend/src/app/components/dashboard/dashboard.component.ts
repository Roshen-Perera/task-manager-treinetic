import {Component, OnInit} from '@angular/core';
import {TaskService} from '../../service/task.service';
import {Task} from '../../model/task';
import {FormsModule} from '@angular/forms';
import {CommonModule, DatePipe} from '@angular/common';

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
    this.taskObject.title = this.taskTitle;
    this.taskObject.status = this.currentStatus;
    this.taskObject.createdAt =
    this.taskObject.description = this.taskDescription;
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

  deleteTask(id: string) {
    this.taskService.deleteTask(id).subscribe(res => {
      console.log("id"+id);
      this.ngOnInit()
    }, err => {
      alert("Failed to delete task");
    });
  }

  constructor(private taskService: TaskService, private date: DatePipe) {

  }

}
