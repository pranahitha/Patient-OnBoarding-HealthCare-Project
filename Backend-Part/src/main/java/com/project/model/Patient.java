package com.project.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

@Entity   
@Table(name="patient")
public class Patient {
	
	@Id	
	private int patientId;
	
	private String patientName;
	
	private String patientContact;
	
	private String patientAddress;
	
	private String patientGender;
	
	private int patientAge;
	
	private String patientGaurdian;
	
	private String gaurdianContact;
	
	private String patientPassword;

}
