package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.AdminEntity;
import com.project.ElectricityBillingSystem.Exceptions.AdminNotFoundException;
import com.project.ElectricityBillingSystem.Repository.AdminRepo;
import com.project.ElectricityBillingSystem.Services.AdminServices;


@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminRepo adminRepo;
	
	@Override
	public List<AdminEntity> getAllAdmin() {
		return adminRepo.findAll();
	}

	@Override
	public Optional<AdminEntity> getAdmin(int id) throws AdminNotFoundException {
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				return adminRepo.findById(id);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}

	@Override
	public AdminEntity addAdmin(AdminEntity adminEntity) {
		// TODO Auto-generated method stub
		return adminRepo.save(adminEntity);
	}

	@Override
	public Optional<AdminEntity> deleteAdmin(int id) throws AdminNotFoundException {

		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				adminRepo.deleteById(id);
				return adminData;
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}
	}

	@Override
	public AdminEntity updateAdmin(int id, AdminEntity adminEntity) throws AdminNotFoundException {
		try {
			Optional<AdminEntity> adminData = adminRepo.findById(id);
			if(adminData!=null) {
				adminEntity.setId(id);
				return adminRepo.save(adminEntity);
			}
			else {
				throw new AdminNotFoundException("Admin Data not found");
			}
		}
		catch(Exception e){
			throw new AdminNotFoundException("Admin Data not found");
		}	
	}
	

}
