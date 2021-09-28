import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/models/patient.model';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  patient?:Patient;
  patientId?: number;
  patientForm?:FormGroup;
  answer?:string;      //to take radio button value 

  
  
  constructor(public router:Router,public activatedRoute: ActivatedRoute,public formBuilder:FormBuilder,public patientService:PatientService) { }

  ngOnInit(): void {


    this.patient = new Patient();
    this.patientId = this.activatedRoute.snapshot.params['patientId'];
    if (this.patientId == -1) {
      //save
      this.patientForm = this.formBuilder.group({     
        patientId:['', [Validators.required, Validators.min(1)]],
        patientName:['', [Validators.required, Validators.minLength(3)]],    
        patientContact:['', [Validators.required, Validators.minLength(10),Validators.maxLength(10)]],    
        patientAddress:['', [Validators.required]],      
      patientGender:['',[Validators.required]], 
      
        patientAge:['', [Validators.required,Validators.min(1)]],      
        patientGaurdian:['', [Validators.required, Validators.minLength(3)]],      
        gaurdianContact:['', [Validators.required, Validators.minLength(10),Validators.maxLength(10)]],      
        patientPassword:['', [Validators.required, Validators.minLength(8),Validators.pattern('[a-zA-Z ]*')]],
      })
    }
    else {
      //edit
      console.log(this.patientId);
      this.patientService.getPatientById(this.patientId)
        .subscribe(data => {
            console.log(data),
            this.patient = data
            //remove
            this.patient.patientGender=this.answer;
            this.patientForm = this.formBuilder.group({
            patientId:[this.patient.patientName, [Validators.required, Validators.min(1)]],
            patientName:[this.patient.patientName, [Validators.required, Validators.minLength(5)]],        
            patientContact:['', [Validators.required, Validators.minLength(5)]],        
            patientAddress:['', [Validators.required, Validators.minLength(5)]],          
           // patientGender:[''],   
           patientGender:[this.answer],        //value stored in answer gets into patientGender model
            patientAge:['', [Validators.required]],          
            patientGaurdian:['', [Validators.required, Validators.minLength(5)]],          
            gaurdianContact:['', [Validators.required, Validators.minLength(5)]],          
            patientPassword:['', [Validators.required, Validators.minLength(5)]],           
          })

          //  this.productForm.get('productId').disable();
        },
          (error: any) => console.log(error)
        )
        
    }
  }

  savePatient() {

    if (this.patientId == -1) {
      //save
     console.log(this.patientId)
      

      this.patientService.savePatient(this.patientForm?.value)
        .subscribe(
          response => {
            console.log(response);
            console.log(this.patientForm.value)
            console.log("#######Saved successfully ");
            this.router.navigate(['patient-login'])
          },
          error => {
           
            console.log(error);
          });

    }
    else {
      //edit
      this.patientService.updatePatient(this.patientForm?.value)
        .subscribe(
          response => {
            console.log(response);
            console.log("#######Updated successfully ");
            this.router.navigate(['patient-login'])
          });
    }

    /*   this.productService.saveProduct(this.productForm?.value).subscribe(data => {
      }),
        (err: string) => this.errorMessage = err
      console.log(this.productForm?.value)
    } */

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
