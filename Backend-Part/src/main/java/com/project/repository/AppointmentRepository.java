package com.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Admin;
import com.project.model.Appointment;


public interface AppointmentRepository extends CrudRepository<Appointment, Integer>  {
	
	//select dateAndTime from appointments
	
		public List<Appointment>findByDate(String date);


}
