package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="admin")
public class Admin {
	
	
	@Id
	
	private int adminId;

	private String adminName;
	
	private String adminPassword;
}
