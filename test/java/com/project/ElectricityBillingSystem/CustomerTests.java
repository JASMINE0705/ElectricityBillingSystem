package com.project.ElectricityBillingSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;
import com.project.ElectricityBillingSystem.Exceptions.CustomerNotFoundException;
import com.project.ElectricityBillingSystem.Services.CustomerServices;



@ExtendWith(MockitoExtension.class)
public class CustomerTests {

	@Mock
	CustomerServices customerService;

	@Test
	void addCustomerTest(){
		CustomerEntity customerEntity = new CustomerEntity(1,"mahii","7896541230","email@gmail.com");
		when(customerService.addCustomer(customerEntity)).thenReturn(customerEntity);
		assertEquals(customerService.addCustomer(customerEntity),customerEntity);
	}
	
	@Test
	void getCustomerTest() throws CustomerNotFoundException {
		CustomerEntity customerEntity = new CustomerEntity(1,"mahii","7896541230","email@gmail.com");
		Optional<CustomerEntity> OCustomerEntity = Optional.of(customerEntity);
		when(customerService.getCustomer(1)).thenReturn(OCustomerEntity);
		assertEquals(customerService.getCustomer(1).get(),customerEntity);
	}
	
	@Test
	void updateCustomerTest() throws CustomerNotFoundException {
		CustomerEntity customerEntity = new CustomerEntity(1,"mahii","7896541230","email@gmail.com");
		when(customerService.updateCustomer(1,customerEntity)).thenReturn(customerEntity);
		assertEquals(customerService.updateCustomer(1,customerEntity),customerEntity);
	}
	
	@Test
	void deleteCustomerTest() throws CustomerNotFoundException {
		CustomerEntity customerEntity = new CustomerEntity(1,"mahii","7896541230","email@gmail.com");
		Optional<CustomerEntity> OCustomerEntity = Optional.of(customerEntity);
		when(customerService.deleteCustomer(1)).thenReturn(OCustomerEntity);
		assertEquals(customerService.deleteCustomer(1).get(),customerEntity);
	}

}
