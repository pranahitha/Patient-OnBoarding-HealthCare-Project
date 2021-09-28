import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';


declare var success: any;
@Component({
  selector: 'app-patient-login',
  templateUrl: './patient-login.component.html',
  styleUrls: ['./patient-login.component.css']
})
export class PatientLoginComponent implements OnInit {


  patient?:Patient;
  patientId?: number;
  patientPassword?:string;
  patientLoginForm?:FormGroup;
  errorMessage?:string;
  constructor(public router:Router,public activatedRoute: ActivatedRoute,public formBuilder:FormBuilder,public patientService:PatientService) { }

  ngOnInit(): void {

    this.patient = new Patient();
     this.patientLoginForm=this.formBuilder.group({

      patientId:['', [Validators.required, Validators.min(1)]],
      patientPassword:['', [Validators.required, Validators.minLength(8),Validators.pattern('[a-zA-Z ]*')]],
     })
  }

  validatePatient(){
   this.patientId=this.patientLoginForm.get('patientId').value;
   this.patientPassword= this.patientLoginForm.get('patientPassword').value;
   this.patientService.validatePatient(this.patientId,this.patientPassword)
   .subscribe(
     response => {
       console.log(response);
       if(response!=null){
        
       }
       else{
         this.errorMessage="Invalid Login Credentials";
          console.log("login failed")
          this.router.navigate(['patient-login'])
       }
       
       
      
     },
     error => {      
            
      console.log("#######Logged successfully ");
      new success();
      this.router.navigate(['patient-login-success'])

     });

  }

  addPatient(){
    //write the code to navigate -- programmaticallly
    // console.log("Add product called")
    this.router.navigate(['signup',"-1"]);
  }

  addDoctor(){
    this.router.navigate(['doctor-signup',"-1"]);
  }

}
