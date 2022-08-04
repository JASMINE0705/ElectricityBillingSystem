package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Repository.LoginRepo;
import com.project.ElectricityBillingSystem.Services.LoginServices;

@Service
public class LoginServicesImpl implements LoginServices {
	
	@Autowired
	public LoginRepo loginRepo;
	
	@Override
	public List<LoginEntity> getAllLogin() {
		return loginRepo.findAll();
	}

	@Override
	public Optional<LoginEntity> getLogin(String email) throws LoginNotFoundException {
		
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				return loginRepo.findById(email);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity addLogin(LoginEntity loginEntity) {
		// TODO Auto-generated method stub
		return loginRepo.save(loginEntity);
	}

	@Override
	public Optional<LoginEntity> deleteLogin(String email) throws LoginNotFoundException {
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginRepo.deleteById(email);
				return loginData;
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}

	@Override
	public LoginEntity updateLogin(String email, LoginEntity loginEntity) throws LoginNotFoundException {
		try {
			Optional<LoginEntity> loginData = loginRepo.findById(email);
			if(loginData!=null) {
				loginEntity.setEmail(email);
				return loginRepo.save(loginEntity);
			}
			else {
				throw new LoginNotFoundException("login Data not found");
			}
		}
		catch(Exception e){
			throw new LoginNotFoundException("login Data not found");
		}
	}
	
}
