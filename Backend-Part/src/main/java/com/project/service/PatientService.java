package com.project.service;

import java.util.List;

import com.project.model.Patient;

public interface PatientService {
	
	public boolean addPatient(Patient patient);
	
	public boolean deleteProduct(int patientId);
	public boolean updatePatient(Patient patient);
	public Patient getPatientById(int patientId);
	public List<Patient> getPatientByName(String patientName);
	public List<Patient> getAllPatient();
	public boolean isPatientExists(int patientId);
	public Patient findPatientFromIdAndPassword(int patientId,String patientPassword);

}
