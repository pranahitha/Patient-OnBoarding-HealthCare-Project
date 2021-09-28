package com.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Doctor;
import com.project.model.Patient;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {

	
	//select doctId from doctor
		public List<Doctor>findByDoctorId(int doctorId);
		
		//select doctorName from doctor
		public List<Doctor>findByDoctorName(String doctorName);
		
		//select doctor specialization from doctor
		public List<Doctor>findByDoctorSpecialisation(String doctorSpecialisation);
		
		
		public Doctor findByDoctorIdAndDoctorPassword(int doctorId,String doctorPassword);
}
