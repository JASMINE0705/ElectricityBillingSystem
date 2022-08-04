package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;

@Service
public interface CustomerServices {
	
	public List<CustomerEntity> getAllCustomer();
	
	public Optional<CustomerEntity> getCustomer(int id) throws CustomerNotFoundException;
	
	public CustomerEntity addCustomer(CustomerEntity customerEntity);
	
	public Optional<CustomerEntity> deleteCustomer(int id) throws CustomerNotFoundException;
	
	public CustomerEntity updateCustomer(int id, CustomerEntity customerEntity) throws CustomerNotFoundException;
	
}
