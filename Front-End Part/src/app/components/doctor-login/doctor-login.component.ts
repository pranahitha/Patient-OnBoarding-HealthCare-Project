import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Doctor } from 'src/app/models/doctor.model';
import { DoctorService } from 'src/app/services/doctor.service';
import { PatientService } from 'src/app/services/patient.service';


declare var success:any;
@Component({
  selector: 'app-doctor-login',
  templateUrl: './doctor-login.component.html',
  styleUrls: ['./doctor-login.component.css']
})
export class DoctorLoginComponent implements OnInit {

  doctor?:Doctor;
  doctorId?: number;
  doctorPassword?:string;
  doctorLoginForm?:FormGroup;
  errorMessage?:string;
  

  constructor(public patientService:PatientService, public router:Router,public activatedRoute: ActivatedRoute,public formBuilder:FormBuilder,public doctorService:DoctorService) { }

  ngOnInit(): void {

    this.doctor = new Doctor();
     this.doctorLoginForm=this.formBuilder.group({

      doctorId:['', [Validators.required, Validators.min(1)]],
      doctorPassword:['', [Validators.required]],
     
    })
  }

  validateDoctor(){

    this.doctorId=this.doctorLoginForm.get('doctorId').value;
    this.doctorPassword= this.doctorLoginForm.get('doctorPassword').value;



    this.doctorService.validateDoctor(this.doctorId,this.doctorPassword)
    .subscribe(
      response => {
        console.log(response);
        if(response!=null){
         
        }
        else{
          this.errorMessage="Invalid Login Credentials";
           console.log("login failed")
           this.router.navigate(['doctor-login'])
        }
        
        
       
      },
      error => {      
             
       console.log("#######Logged successfully ");
       new success();
       this.router.navigate(['doctor-dashboard'])
 
      });


     
   
  }

  addDoctor(){
    this.router.navigate(['doctor-signup',"-1"]);
  }
  addPatient(){
    //write the code to navigate -- programmaticallly
    // console.log("Add product called")
    this.router.navigate(['signup',"-1"]);
  }

}
