import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
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
