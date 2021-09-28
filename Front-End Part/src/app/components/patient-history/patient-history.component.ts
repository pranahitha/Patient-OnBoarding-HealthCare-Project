import { Component, OnInit } from '@angular/core';
import{ Patient} from 'src/app/models/patient.model';
import{ PatientService} from 'src/app/services/patient.service';
@Component({
  selector: 'app-patient-history',
  templateUrl: './patient-history.component.html',
  styleUrls: ['./patient-history.component.css']
})
export class PatientHistoryComponent implements OnInit {
  patients:Patient[]=[];
  constructor(public patientHistory:PatientService) { }

  ngOnInit(): void {
    this.patientHistory.getPatients().subscribe((data: any[])=>{
      console.log("###Patients History recieved from spring :"  );
          // console.log(data);
      this.patients = data;
     
    },err=>
    
    console.log(err)) 
  
    

  }

}
