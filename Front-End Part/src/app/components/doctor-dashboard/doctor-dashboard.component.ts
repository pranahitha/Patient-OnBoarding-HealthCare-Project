import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewAppointmentsService } from 'src/app/services/view-appointments.service';
import { ViewAppointmentsComponent } from '../view-appointments/view-appointments.component';
declare var success:any;
@Component({
  selector: 'app-doctor-dashboard',
  templateUrl: './doctor-dashboard.component.html',
  styleUrls: ['./doctor-dashboard.component.css']
})
export class DoctorDashboardComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
    
  }

  getAppointment(){
    console.log("called");  
    this.router.navigate(['view-appiontment']);
  }

}
