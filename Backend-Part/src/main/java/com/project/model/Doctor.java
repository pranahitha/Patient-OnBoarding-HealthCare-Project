package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	private int doctorId;
	private String doctorName;
	private String doctorSpecialisation;
	private String doctorPassword;
}
