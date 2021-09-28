import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { BookAppointment } from '../models/book-appointment.model';



const appointmentUrl="http://localhost:9090/appointment";

@Injectable({
  providedIn: 'root'
})
export class BookAppointmentService {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  constructor(public http:HttpClient) { 

  }

  getAppointments() :Observable<BookAppointment[]>{
    return this.http.get<BookAppointment[]>(appointmentUrl)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  getAppointmentById(appointmentNumber:number):Observable<BookAppointment>{
    return this.http.get<BookAppointment>(`${appointmentUrl}/${appointmentNumber}`)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    );
  }

  saveAppointment(appointment:BookAppointment):Observable<BookAppointment>{
    return this.http.post<BookAppointment>(appointmentUrl, appointment ,this.httpOptions)
    .pipe(
      retry(1),
      catchError(this.errorHandler)
    )
  }


 

  // saveProduct(product: Product): Observable<Product> {
  //   return this.http.post<Product>(productUrl, product, this.httpOptions)
  //     .pipe(
  //       retry(1),
  //       catchError(this.errorHandler)
  //     )
  // }  

  

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
