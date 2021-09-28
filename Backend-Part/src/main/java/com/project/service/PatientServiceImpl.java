package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Patient;
import com.project.repository.PatientRepository;

@Service
public class PatientServiceImpl implements  PatientService {

	
	@Autowired
	PatientRepository patientRepository;
	
	
	@Override
	public boolean addPatient(Patient patient) {
		patientRepository.save(patient);
		return true;
	}

	@Override
	public boolean deleteProduct(int patientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientById(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientByName(String patientName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getAllPatient() {
		return (List<Patient>) patientRepository.findAll();
	}

	@Override
	public boolean isPatientExists(int patientId) {
		Optional<Patient> patientData = patientRepository.findById(patientId);
		return patientData.isPresent();
	}

	@Override
	public Patient findPatientFromIdAndPassword(int patientId, String patientPassword) {
		Patient patient= patientRepository.findByPatientIdAndPatientPassword(patientId, patientPassword);
		return patient;
	}

	

}
