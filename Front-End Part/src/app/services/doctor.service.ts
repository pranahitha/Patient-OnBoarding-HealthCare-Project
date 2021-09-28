
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { Doctor } from '../models/doctor.model';
import { retry ,catchError } from 'rxjs/operators';

const doctorUrl= "http://localhost:9090/doctor";
@Injectable({
  providedIn: 'root'
})
export class DoctorService {
  
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  constructor(public http:HttpClient) { }

  getDoctors() :Observable<Doctor[]>{
    return this.http.get<Doctor []>(doctorUrl)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  getDoctorById(doctorId:number) :Observable<Doctor>{
    return this.http.get<Doctor>(`${doctorUrl}/${doctorId}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  deleteDoctor(doctorId:number){
    return this.http.delete(`${doctorUrl}/${doctorId}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }

  saveDoctor(doctor:Doctor):Observable<Doctor>{
    return this.http.post<Doctor>(doctorUrl, doctor ,this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }


  updateDoctor(doctor:Doctor):Observable<Doctor>{
    return this.http.put<Doctor>(doctorUrl, doctor ,this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }

  validateDoctor(doctorId:number,doctorPassword:string){
    return this.http.get(`${doctorUrl}/${doctorId}/${doctorPassword}`)
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
  console.log(errorMessage);
  return throwError(errorMessage)
  }

}
