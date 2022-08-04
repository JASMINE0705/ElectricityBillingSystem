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

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;
import com.project.ElectricityBillingSystem.Services.PaymentServices;



@ExtendWith(MockitoExtension.class)
public class PaymentTests {

	@Mock
	PaymentServices paymentService;

	@Test
	void addPaymentTest(){
		PaymentEntity paymentEntity = new PaymentEntity(1,"CASH",1520);
		when(paymentService.addPayment(paymentEntity)).thenReturn(paymentEntity);
		assertEquals(paymentService.addPayment(paymentEntity),paymentEntity);
	}
	
	@Test
	void getPaymentTest() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity(1,"CASH",1520);
		Optional<PaymentEntity> OPaymentEntity = Optional.of(paymentEntity);
		when(paymentService.getPayment(1)).thenReturn(OPaymentEntity);
		assertEquals(paymentService.getPayment(1).get(),paymentEntity);
	}
	
	@Test
	void updatePaymentTest() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity(1,"CASH",1520);
		when(paymentService.updatePayment(1,paymentEntity)).thenReturn(paymentEntity);
		assertEquals(paymentService.updatePayment(1,paymentEntity),paymentEntity);
	}
	
	@Test
	void deletePaymentTest() throws PaymentNotFoundException {
		PaymentEntity paymentEntity = new PaymentEntity(1,"CASH",1520);
		Optional<PaymentEntity> OPaymentEntity = Optional.of(paymentEntity);
		when(paymentService.deletePayment(1)).thenReturn(OPaymentEntity);
		assertEquals(paymentService.deletePayment(1).get(),paymentEntity);
	}

}
