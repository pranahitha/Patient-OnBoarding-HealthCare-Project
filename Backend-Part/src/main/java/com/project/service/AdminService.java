package com.project.service;

import java.util.List;

import com.project.model.Admin;

public interface AdminService {
	
	public boolean addAdmin(Admin admin);
	
	public boolean deleteAdmin(int adminId);
	public boolean updateAdmin(Admin admin);
	public Admin getAdminById(int adminId);
	public List<Admin> getAdminByName(String adminName);
	public List<Admin> getAllAdmin();
	public boolean isAdminExists(int adminId);

}
