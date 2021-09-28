package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Doctor;
import com.project.model.Patient;
import com.project.service.DoctorService;

@RestController
@RequestMapping("doctor")
@CrossOrigin(origins="http://localhost:4200")

public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@GetMapping
	public ResponseEntity<List<Doctor>> getDoctors(@RequestParam(required = false)String doctorName )
	{
		System.out.println("All doctors called");
		ResponseEntity<List<Doctor>> responseEntity = null;
		List<Doctor> doctors = new ArrayList<Doctor>();
		if(doctorName == null)
		{
			doctors = doctorService.getAllDoctors();
		}else
		{
			doctors = doctorService.getDoctorByName(doctorName);
		}
		if(doctors.size() == 0)
		{
			responseEntity = new ResponseEntity<List<Doctor>>(doctors,HttpStatus.NO_CONTENT);
		}else
		{
			responseEntity = new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@GetMapping("{doctorId}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId")int doctorId)
	{
		System.out.println(" Get DOCTOR BY ID is called "+doctorId);
		ResponseEntity<Doctor> responseEntity = null;
		Doctor doctor = new Doctor();
		if(doctorService.isDoctorExists(doctorId))
		{
			doctor = doctorService.getDoctorById(doctorId);
			responseEntity = new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
		}else
		{
			responseEntity = new ResponseEntity<Doctor>(doctor,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	@GetMapping("/searchByName/{doctorName}")
	public List<Doctor> getDoctorByName(@PathVariable("doctorName")String doctorName)
	{
		System.out.println(" Get Doctor By Name is  "+doctorName);
		return doctorService.getDoctorByName(doctorName);
	}
	
	@GetMapping("/searchBySpecialization/{doctorSpecialisation}")
	public List<Doctor> getDoctorBySpecialization(@PathVariable("doctorSpecialisation")String doctorSpecialisation)
	{
		System.out.println(" Get Doctor By Specialisation is  "+doctorSpecialisation);
		return doctorService.getDoctorSpecialisation(doctorSpecialisation);
	}
	
	@PostMapping
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor)
	{
		ResponseEntity<String> responseEntity = null;
		int doctorId = doctor.getDoctorId();
		String message = null;
		if(doctorService.isDoctorExists(doctorId))
		{
			message="doctor with doctor id : "+doctorId+ " already exists";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}else
		{
			doctorService.addDoctor(doctor);
			message = "doctor with doctor id : "+doctorId+ " saved successfully";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}
		/*
		 * System.out.println("add doctor called"); System.out.println( doctor);
		 */
		return responseEntity;
	}
	
	@PutMapping
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor  doctor)
	{
		ResponseEntity<String> responseEntity = null;
		int doctorId = doctor.getDoctorId();
		String message = null;
		if(doctorService.isDoctorExists(doctorId))
		{
			doctorService.updateDoctor(doctor);
			message="doctor with doctor id : "+doctorId+ " updated";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			message = "doctor with doctor id : "+doctorId+ " does not exists";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}
		
		  System.out.println("PUT doctors called");
		  System.out.println( doctor);
		 
		return responseEntity;
	}
	@DeleteMapping("{doctorId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("doctorId")int doctorId)
	{
		System.out.println("DELETE doctors called "+doctorId);
		
		ResponseEntity<String> responseEntity = null;
		String message = null;
		if(doctorService.isDoctorExists(doctorId))
		{
			doctorService.deleteDoctor(doctorId);
			message="Doctor with id :"+doctorId+"deleted Successfully";
			responseEntity = new ResponseEntity<String>(message,HttpStatus.OK);
		}
		else
		{
			responseEntity = new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@GetMapping("/{doctorId}/{doctorPassword}")
	public ResponseEntity<String> validatePatient(@PathVariable int doctorId,@PathVariable String doctorPassword){
		ResponseEntity<String> responseEntity=null;
		String message=null;
		if(doctorService.isDoctorExists(doctorId)) {
			Doctor doctor= doctorService.findDoctorFromIdAndPassword(doctorId,doctorPassword);
			if(doctor!=null) {
				message="Successfully Login";
				responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
			}else {
				message="Login Failed";
				responseEntity=new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
			}
		}else {
			message="User not found";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.NO_CONTENT);
			
		}
		return responseEntity; 
	}
	

}
