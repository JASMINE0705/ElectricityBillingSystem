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

import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.Services.BillingServices;


@ExtendWith(MockitoExtension.class)
public class BillingTests {

	@Mock
	BillingServices billingService;

	@Test
	void addBillingTest(){
		BillingEntity billingEntity = new BillingEntity(1,12,120,"2022-12-12","2022-12-12","2022-12-12");
		when(billingService.addBilling(billingEntity)).thenReturn(billingEntity);
		assertEquals(billingService.addBilling(billingEntity),billingEntity);
	}
	
	@Test
	void getBillingTest() throws BillingNotFoundException {
		BillingEntity billingEntity = new BillingEntity(1,12,120,"2022-12-12","2022-12-12","2022-12-12");
		Optional<BillingEntity> OBillingEntity = Optional.of(billingEntity);
		when(billingService.getBilling(1)).thenReturn(OBillingEntity);
		assertEquals(billingService.getBilling(1).get(),billingEntity);
	}
	
	@Test
	void updateBillingTest() throws BillingNotFoundException {
		BillingEntity billingEntity = new BillingEntity(1,12,120,"2022-12-12","2022-12-12","2022-12-12");
		when(billingService.updateBilling(1,billingEntity)).thenReturn(billingEntity);
		assertEquals(billingService.updateBilling(1,billingEntity),billingEntity);
	}
	
	@Test
	void deleteBillingTest() throws BillingNotFoundException {
		BillingEntity billingEntity = new BillingEntity(1,12,120,"2022-12-12","2022-12-12","2022-12-12");
		Optional<BillingEntity> OBillingEntity = Optional.of(billingEntity);
		when(billingService.deleteBilling(1)).thenReturn(OBillingEntity);
		assertEquals(billingService.deleteBilling(1).get(),billingEntity);
	}

}
