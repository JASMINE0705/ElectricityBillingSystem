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

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;
import com.project.ElectricityBillingSystem.Services.ServiceServices;



@ExtendWith(MockitoExtension.class)
public class ServiceTests {

	@Mock
	ServiceServices serviceService;

	@Test
	void addServiceTest() throws ServiceNotFoundException{
		ServiceEntity serviceEntity = new ServiceEntity(1,"commercial");
		when(serviceService.addService(serviceEntity)).thenReturn(serviceEntity);
		assertEquals(serviceService.addService(serviceEntity),serviceEntity);
	}
	
	@Test
	void getServiceTest() throws ServiceNotFoundException {
		ServiceEntity serviceEntity = new ServiceEntity(1,"commercial");
		Optional<ServiceEntity> OServiceEntity = Optional.of(serviceEntity);
		when(serviceService.getService(1)).thenReturn(OServiceEntity);
		assertEquals(serviceService.getService(1).get(),serviceEntity);
	}
	
	@Test
	void updateServiceTest() throws ServiceNotFoundException {
		ServiceEntity serviceEntity = new ServiceEntity(1,"commercial");
		when(serviceService.updateService(1,serviceEntity)).thenReturn(serviceEntity);
		assertEquals(serviceService.updateService(1,serviceEntity),serviceEntity);
	}
	
	@Test
	void deleteServiceTest() throws ServiceNotFoundException {
		ServiceEntity serviceEntity = new ServiceEntity(1,"commercial");
		Optional<ServiceEntity> OServiceEntity = Optional.of(serviceEntity);
		when(serviceService.deleteService(1)).thenReturn(OServiceEntity);
		assertEquals(serviceService.deleteService(1).get(),serviceEntity);
	}

}
