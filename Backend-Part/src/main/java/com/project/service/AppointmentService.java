package com.project.service;

import java.util.List;

import com.project.model.Appointment;

  
  public interface AppointmentService {
  
  //crud
  
  public boolean addAppointment(Appointment appointment); 
  public boolean deleteAppointment(int appointmentNumber);
  public boolean updateAppointment(Appointment appointment);
  public boolean isAppointmentExists(int appointmentNumber);

  //appointment functionalities 
  
  public List<Appointment> getAllAppointments();
 
  public List<Appointment> getAppointmentForDay(String date); 
  //public Map<String, Appointment>getAppointmentsForDay(Date day);
  
  
  }