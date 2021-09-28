package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Doctor;
import com.project.repository.DoctorRepository;
@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Transactional
	@Override
	public boolean addDoctor(Doctor doctor) {
		System.out.println("---add doctor - Service ---");
		doctorRepository.save(doctor);
		return true;
	}
	
	@Transactional
	@Override
	public boolean deleteDoctor(int doctorId) {
			System.out.println("---delete doctor service ---");
			doctorRepository.deleteById(doctorId);
			return true;
	}

	
	@Transactional
	@Override
	public boolean updateDoctor(Doctor doctor) {
		System.out.println("----- update doctor called -Service");
		doctorRepository.save(doctor);
		return true;
	}
	@Transactional
	@Override
	public Doctor getDoctorById(int doctorId) {
		
		System.out.println("----- doctor by id called -Service");
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		Doctor doctor = doctorData.get();
		return doctor;
	
	}
	@Transactional
	@Override
	public List<Doctor> getDoctorByName(String doctorName) {
		
		return doctorRepository.findByDoctorName(doctorName);
	}
	@Transactional
	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return (List<Doctor>)doctorRepository.findAll();
	}
	@Transactional
	@Override
	public boolean isDoctorExists(int doctorId) {
		Optional<Doctor> doctorData = doctorRepository.findById(doctorId);
		
		return doctorData.isPresent();
	}
	@Transactional
	@Override
	public List<Doctor> getDoctorSpecialisation(String doctorSpecialisation) {
		
		return doctorRepository.findByDoctorSpecialisation(doctorSpecialisation);
	}

	@Override
	public Doctor findDoctorFromIdAndPassword(int doctorId, String doctorPassword) {
		return doctorRepository.findByDoctorIdAndDoctorPassword(doctorId, doctorPassword);
	}

}
