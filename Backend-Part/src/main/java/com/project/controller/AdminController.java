package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Admin;
import com.project.model.Patient;
import com.project.service.AdminService;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	
	@GetMapping
	public ResponseEntity<List<Admin>> getAdmin(){
		
		ResponseEntity<List<Admin>> responseEntity=null;
		List<Admin> admin= adminService.getAllAdmin();
		if(admin.size()==0) {
			responseEntity=new ResponseEntity<List<Admin>>(admin,HttpStatus.OK);
		}else {
			responseEntity=new ResponseEntity<List<Admin>>(admin,HttpStatus.OK);
		}
		return responseEntity;
		
	}
	
	@PostMapping
	public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {//Working
		ResponseEntity<String> responseEntity=null;
		int adminId=admin.getAdminId();
		String message=null;
		if(adminService.isAdminExists(adminId)) {
//			message="Product with ProductId : "+patientId+" is already exists ";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			adminService.addAdmin(admin);
//			message="Patient with PatientId : "+patientId+" is saved successfully";
			responseEntity=new ResponseEntity<String>(message,HttpStatus.OK);
			
		}
		return responseEntity;
	}
	
	

}
