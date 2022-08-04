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

import com.project.ElectricityBillingSystem.Entity.LoginEntity;
import com.project.ElectricityBillingSystem.Exceptions.LoginNotFoundException;
import com.project.ElectricityBillingSystem.Services.LoginServices;



@ExtendWith(MockitoExtension.class)
public class LoginTests {

	@Mock
	LoginServices loginService;

	@Test
	void addLoginTest(){
		LoginEntity loginEntity = new LoginEntity("email@gmail.com","pass","ROlE",10);
		when(loginService.addLogin(loginEntity)).thenReturn(loginEntity);
		assertEquals(loginService.addLogin(loginEntity),loginEntity);
	}
	
	@Test
	void getLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("email@gmail.com","pass","ROlE",10);
		Optional<LoginEntity> OLoginEntity = Optional.of(loginEntity);
		when(loginService.getLogin("email@gmail.com")).thenReturn(OLoginEntity);
		assertEquals(loginService.getLogin("email@gmail.com").get(),loginEntity);
	}
	
	@Test
	void updateLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("email@gmail.com","pass","ROlE",10);
		when(loginService.updateLogin("email@gmail.com",loginEntity)).thenReturn(loginEntity);
		assertEquals(loginService.updateLogin("email@gmail.com",loginEntity),loginEntity);
	}
	
	@Test
	void deleteLoginTest() throws LoginNotFoundException {
		LoginEntity loginEntity = new LoginEntity("email@gmail.com","pass","ROlE",10);
		Optional<LoginEntity> OLoginEntity = Optional.of(loginEntity);
		when(loginService.deleteLogin("email@gmail.com")).thenReturn(OLoginEntity);
		assertEquals(loginService.deleteLogin("email@gmail.com").get(),loginEntity);
	}

}
