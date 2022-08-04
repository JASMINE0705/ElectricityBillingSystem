package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Repository.CustomerRepo;
import com.project.ElectricityBillingSystem.Services.CustomerServices;

@Service
public class CustomerServiceImpl implements CustomerServices {

	@Autowired
	public CustomerRepo customerRepo;
	
	@Override
	public List<CustomerEntity> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	@Override
	public Optional<CustomerEntity> getCustomer(int id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				return customerRepo.findById(id);
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		}
	}

	@Override
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {
		// TODO Auto-generated method stub
		return customerRepo.save(customerEntity);
	}

	@Override
	public Optional<CustomerEntity> deleteCustomer(int id) throws CustomerNotFoundException {
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				customerRepo.deleteById(id);
				return customerData;
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		}
	}

	@Override
	public CustomerEntity updateCustomer(int id, CustomerEntity customerEntity) throws CustomerNotFoundException {
		try {
			Optional<CustomerEntity> customerData = customerRepo.findById(id);
			if(customerData!=null) {
				customerEntity.setId(id);
				return customerRepo.save(customerEntity);
			}
			else {
				throw new CustomerNotFoundException("Customer Data not found");
			}
		}
		catch(Exception e){
			throw new CustomerNotFoundException("Customer Data not found");
		
		}	
		
	}
}
