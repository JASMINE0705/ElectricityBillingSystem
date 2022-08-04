package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.PaymentEntity;
import com.project.ElectricityBillingSystem.Exceptions.PaymentNotFoundException;
import com.project.ElectricityBillingSystem.Repository.PaymentRepo;
import com.project.ElectricityBillingSystem.Services.PaymentServices;

@Service
public class PaymentServiceImpl implements PaymentServices{

	@Autowired
	private PaymentRepo paymentRepo;
	
	@Override
	public List<PaymentEntity> getAllPayment() {
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}

	@Override
	public Optional<PaymentEntity> getPayment(int id) throws PaymentNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				return paymentRepo.findById(id);
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		
		}	
	}

	@Override
	public PaymentEntity addPayment(PaymentEntity paymentEntity) {
		// TODO Auto-generated method stub
		return paymentRepo.save(paymentEntity);

	}

	@Override
	public Optional<PaymentEntity> deletePayment(int id) throws PaymentNotFoundException {
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				paymentRepo.deleteById(id);
				return paymentData;
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		}
	}

	@Override
	public PaymentEntity updatePayment(int id, PaymentEntity paymentEntity) throws PaymentNotFoundException {
		try {
			Optional<PaymentEntity> paymentData = paymentRepo.findById(id);
			if(paymentData!=null) {
				paymentEntity.setId(id);
				return paymentRepo.save(paymentEntity);
			}
			else {
				throw new PaymentNotFoundException("Payment Data not found");
			}
		}
		catch(Exception e){
			throw new PaymentNotFoundException("Payment Data not found");
		
		}	
	}

}
