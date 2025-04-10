import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';  // Import HttpClientModule
import { AppComponent } from './app.component';
import {DashboardComponent} from './components/dashboard/dashboard.component';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, HttpClientModule, DashboardComponent],  // Add HttpClientModule here
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
