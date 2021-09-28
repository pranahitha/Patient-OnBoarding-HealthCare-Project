package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Admin;
import com.project.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	
	@Override
	public boolean addAdmin(Admin admin) {
		adminRepository.save(admin);
		return true;
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAdminByName(String adminName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Admin> getAllAdmin() {
		return (List<Admin>) adminRepository.findAll();
	}

	@Override
	public boolean isAdminExists(int adminId) {
		Optional<Admin> adminData = adminRepository.findById(adminId);
		return adminData.isPresent();
	}

}
