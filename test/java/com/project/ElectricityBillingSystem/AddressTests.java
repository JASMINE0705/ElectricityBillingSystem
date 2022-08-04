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

import com.project.ElectricityBillingSystem.Entity.AddressEntity;
import com.project.ElectricityBillingSystem.Exceptions.AddressNotFoundException;
import com.project.ElectricityBillingSystem.Services.AddressService;


@ExtendWith(MockitoExtension.class)
public class AddressTests {

	@Mock
	AddressService addressService;

	@Test
	void addAddressTest(){
		AddressEntity addressEntity = new AddressEntity(1,"123","Rb Road","Hyd","Telangana");
		when(addressService.addAddress(addressEntity)).thenReturn(addressEntity);
		assertEquals(addressService.addAddress(addressEntity),addressEntity);
	}
	
	@Test
	void getAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"123","Rb Road","Hyd","Telangana");
		Optional<AddressEntity> OAddressEntity = Optional.of(addressEntity);
		when(addressService.getAddress(1)).thenReturn(OAddressEntity);
		assertEquals(addressService.getAddress(1).get(),addressEntity);
	}
	
	@Test
	void updateAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"123","Rb Road","Hyd","Telangana");
		when(addressService.updateAddress(1,addressEntity)).thenReturn(addressEntity);
		assertEquals(addressService.updateAddress(1,addressEntity),addressEntity);
	}
	
	@Test
	void deleteAddressTest() throws AddressNotFoundException {
		AddressEntity addressEntity = new AddressEntity(1,"123","Rb Road","Hyd","Telangana");
		Optional<AddressEntity> OAddressEntity = Optional.of(addressEntity);
		when(addressService.deleteAddress(1)).thenReturn(OAddressEntity);
		assertEquals(addressService.deleteAddress(1).get(),addressEntity);
	}

}
