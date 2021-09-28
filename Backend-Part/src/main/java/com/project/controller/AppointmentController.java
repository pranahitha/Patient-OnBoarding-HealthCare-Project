package com.project.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Appointment;
import com.project.service.AppointmentService;

@RestController
@RequestMapping("appointment")
@CrossOrigin(origins="http://localhost:4200")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping
	public ResponseEntity<String> addAppointment(@RequestBody Appointment appointment)
	{
		ResponseEntity<String> responseEntity=null;
		int appointmentId = appointment.getAppointmentId();
		String message = null;
		if(appointmentService.isAppointmentExists(appointmentId))
		{
			message=" Appointment number : "+appointmentId+" already appointed";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
			
		}else
		{
			appointmentService.addAppointment(appointment);
			message="Appointment number is : "+appointmentId+" has been appointed successfully";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping
	public ResponseEntity<List<Appointment>> getAppointments()
	{
		ResponseEntity<List<Appointment>> responseEntity=null;
		List<Appointment> appointments = appointmentService.getAllAppointments();
		
		if(appointments.size()==0)
		{
		
			responseEntity = new ResponseEntity<List<Appointment>>(appointments,HttpStatus.NO_CONTENT);
			
		}else
		{
			responseEntity = new ResponseEntity<List<Appointment>>(appointments,HttpStatus.OK);
				
		}
		return responseEntity;
		
	}
	
	@GetMapping("/searchByDate/{date}")
	public List<Appointment> getByDateAndTime(@PathVariable("date")String date)
	{
		System.out.println("get Patient Appointment Details for the Day is  "+date);
		return appointmentService.getAppointmentForDay(date);
	}

}
