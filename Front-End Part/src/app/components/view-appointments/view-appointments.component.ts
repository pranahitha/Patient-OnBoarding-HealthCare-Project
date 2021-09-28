import { Component, OnInit } from '@angular/core';
import { BookAppointment } from 'src/app/models/book-appointment.model';
import { BookAppointmentService } from 'src/app/services/book-appointment.service';

@Component({
  selector: 'app-view-appointments',
  templateUrl: './view-appointments.component.html',
  styleUrls: ['./view-appointments.component.css']
})
export class ViewAppointmentsComponent implements OnInit {
  appointments:BookAppointment[]=[];
  constructor(public bookAppointmentService:BookAppointmentService) { }
  
  ngOnInit(): void {

    
      this.bookAppointmentService.getAppointments().subscribe((data: any[])=>{
         console.log("###Products recieved from spring :")
        // console.log(data);
        this.appointments = data;
       
      },err=>
      
      console.log(err)) 
    
  }

 



}
