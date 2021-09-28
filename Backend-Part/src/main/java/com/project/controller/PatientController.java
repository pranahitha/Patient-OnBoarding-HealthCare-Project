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

import com.project.model.Patient;
import com.project.service.PatientService;

@RestController
@RequestMapping("patient")
@CrossOrigin(origins="http://localhost:4200")

public class PatientController {
	
	
	@Autowired
	PatientService patientService;
	
	@GetMapping
	public ResponseEntity<List<Patient>> getPatient(){//Working
		ResponseEntity<List<Patient>> responseEntity=null;
		List<Patient> patient=patientService.getAllPatient();
		if(patient.size()==0) {
			responseEntity=new ResponseEntity<List<Patient>>(patient,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<List<Patient>>(patient,HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@PostMapping
	public ResponseEntity<String> addPatient(@RequestBody Patient patient) {//Working
		ResponseEntity<String> responseEntity=null;
		int patientId=patient.getPatientId();
		String message=null;
		if(patientService.isPatientExists(patientId)) {
//			message="Product with ProductId : "+patientId+" is already exists ";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			patientService.addPatient(patient);
//			message="Patient with PatientId : "+patientId+" is saved successfully";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
			
		}
		return responseEntity; 
	}
	
	

	@GetMapping("/{patientId}/{patientPassword}")
	public ResponseEntity<String> validatePatient(@PathVariable int patientId,@PathVariable String patientPassword){
		ResponseEntity<String> responseEntity=null;
		String message=null;
		if(patientService.isPatientExists(patientId)) {
			Patient patient= patientService.findPatientFromIdAndPassword(patientId,patientPassword);
			if(patient!=null) {
				message="Suuceefully Login";
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
