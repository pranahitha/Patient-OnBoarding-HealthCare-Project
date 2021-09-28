
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { Patient } from '../models/patient.model';
import { retry ,catchError } from 'rxjs/operators';

const patientUrl= "http://localhost:9090/patient";


@Injectable({
  providedIn: 'root'
})
export class PatientService {

  

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  constructor(public http:HttpClient) { }

  getPatients() :Observable<Patient[]>{
    return this.http.get<Patient []>(patientUrl)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  getPatientById(patientId:number):Observable<Patient>{
    return this.http.get<Patient>(`${patientUrl}/${patientId}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  deletePatient(patientId:number){
    return this.http.delete(`${patientUrl}/${patientId}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }

  savePatient(patient:Patient):Observable<Patient>{
    return this.http.post<Patient>(patientUrl, patient ,this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }


  updatePatient(patient:Patient):Observable<Patient>{
    return this.http.put<Patient>(patientUrl, patient ,this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }


  validatePatient(patientId:number,patientPassword:string){
    return this.http.get(`${patientUrl}/${patientId}/${patientPassword}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }

 



  errorHandler(error: { error: { message: string; }; status: any; message: any; }){
  let errorMessage='';
  if(error.error instanceof ErrorEvent ) {
     errorMessage=error.error.message;
  }else{
      errorMessage=`Error Code:${error.status}\nMessage:${error.message}`;
  }

  return throwError(errorMessage)
  }

}
