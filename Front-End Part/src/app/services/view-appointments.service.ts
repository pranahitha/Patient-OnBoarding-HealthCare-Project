import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { BookAppointment } from '../models/book-appointment.model';
const patientUrl= "http://localhost:9090/appointment";
@Injectable({
  providedIn: 'root'
})


export class ViewAppointmentsService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  constructor(public http:HttpClient) { }

  getAppointments() :Observable<BookAppointment[]>{
    return this.http.get<BookAppointment []>(patientUrl)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
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
