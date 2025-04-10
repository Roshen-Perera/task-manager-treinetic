import {Component, OnInit} from '@angular/core';
import {TaskService} from '../../service/task.service';
import {Task} from '../../model/task';

@Component({
  selector: 'app-dashboard',
  imports: [],
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})
export class DashboardComponent implements OnInit{

  taskObject : Task = new Task();
  taskList : Task[] = [];
  currentDate: string | null = '';
  currentStatus: string  = 'PENDING';

  title = '';
  description = '';

  ngOnInit(): void {
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

  addTask(task : Task) {
    this.taskService.addTask(task).subscribe(res => {
      this.ngOnInit()
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

  deleteTask(task: Task) {
    this.taskService.deleteTask(task).subscribe(res => {
      this.ngOnInit()
    }, err => {
      alert("Failed to delete task");
    });
  }

  constructor(private taskService: TaskService) {

  }

}
