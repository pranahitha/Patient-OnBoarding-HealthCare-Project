package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
	
	public Patient findByPatientIdAndPatientPassword(int patientId,String patientPassword);

}
