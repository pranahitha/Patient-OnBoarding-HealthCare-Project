package com.project.model;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

@Table(name = "appointment")
public class Appointment {
	@Id
	
	private int appointmentId;
	private String patientName;	
	private String reasonToVisit;
	private String date;
	private String time;
	private int consultationFee;

}
