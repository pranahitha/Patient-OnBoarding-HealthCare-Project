package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.model.Doctor;

public interface DoctorService {

	
	public boolean addDoctor(Doctor doctor);
	public boolean deleteDoctor(int doctorId);
	public boolean updateDoctor(Doctor doctor);
	
	public Doctor getDoctorById(int doctorId);
	public List<Doctor> getDoctorByName(String doctorName);
	public List<Doctor> getDoctorSpecialisation(String doctorSpecialisation);
	public List<Doctor> getAllDoctors();
	public boolean isDoctorExists(int doctorId);
	public Doctor findDoctorFromIdAndPassword(int doctorId,String doctorPassword);
}
