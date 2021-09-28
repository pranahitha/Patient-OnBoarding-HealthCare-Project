import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { PatientLoginComponent } from './components/patient-login/patient-login.component';
import { DoctorLoginComponent } from './components/doctor-login/doctor-login.component';
import { SignupComponent } from './components/signup/signup.component';
import { PatientLoginSuccessComponent } from './components/patient-login-success/patient-login-success.component';
import { AboutAppComponent } from './components/about-app/about-app.component';
import { DoctorSignupComponent } from './components/doctor-signup/doctor-signup.component';
import { BookAppointment } from './models/book-appointment.model';
import { BookAppointmentComponent } from './components/book-appointment/book-appointment.component';
import { DoctorDashboardComponent } from './components/doctor-dashboard/doctor-dashboard.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { ViewAppointmentsComponent } from './components/view-appointments/view-appointments.component';
import{ OrderMedicinesComponent} from './components/order-medicines/order-medicines.component';
import { PatientHistoryComponent } from './components/patient-history/patient-history.component';
import { HealthRecordsComponent } from './components/health-records/health-records.component';
import { NewRecordComponent } from './components/new-record/new-record.component';

const routes: Routes = [
  { path: '', component:HomePageComponent },
  { path: 'patient-login', component:PatientLoginComponent },
  { path: 'doctor-login', component:DoctorLoginComponent },
  {path:'doctor-signup/:doctorId',component:DoctorSignupComponent},
  {path:'about',component:AboutUsComponent},
  {path:'contact',component:ContactUsComponent},
  { path: 'signup/:patientId', component:SignupComponent },
  { path: 'patient-login-success', component:PatientLoginSuccessComponent },
  { path: 'about-app', component:AboutAppComponent },
  {path:'book-appointment',component:BookAppointmentComponent},
  { path: 'doctor-dashboard', component:DoctorDashboardComponent},
  {path:'view-appiontment',component:ViewAppointmentsComponent},
  {path:'order-medicines', component:OrderMedicinesComponent},
  {path:'patient-history',component:PatientHistoryComponent},
  {path : 'record',component:HealthRecordsComponent},
  {path:'new-record',component:NewRecordComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
