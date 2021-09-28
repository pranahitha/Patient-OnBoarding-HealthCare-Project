import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-patient-login-success',
  templateUrl: './patient-login-success.component.html',
  styleUrls: ['./patient-login-success.component.css']
})
export class PatientLoginSuccessComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
   
  }

 

}
