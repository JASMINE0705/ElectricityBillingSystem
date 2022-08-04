package com.project.ElectricityBillingSystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Services.CustomerServices;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServices customerServices;
	
	@GetMapping("/customer")
	public List<CustomerEntity> getAllLogin() {
		return customerServices.getAllCustomer();
	}
	
	@GetMapping("customer/{id}")
	public Optional<CustomerEntity> getLoginById(@PathVariable int id) throws CustomerNotFoundException {
		return customerServices.getCustomer(id);
	}
	
	@PostMapping("customer")
	public CustomerEntity addLogin(@Valid @RequestBody CustomerEntity customerEntity) {
		return customerServices.addCustomer(customerEntity);
	}
	
	@PutMapping("customer/{id}")
	public CustomerEntity updateLogin(@PathVariable int id,@Valid @RequestBody CustomerEntity customerEntity) throws CustomerNotFoundException {
		return customerServices.updateCustomer(id, customerEntity);
	}
	
	@DeleteMapping("customer/{id}")
	public Optional<CustomerEntity> deleteLogin(@PathVariable int id) throws CustomerNotFoundException {
		return customerServices.deleteCustomer(id);
	}
}
