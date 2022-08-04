package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;
import com.project.ElectricityBillingSystem.Repository.BillingRepo;
import com.project.ElectricityBillingSystem.Services.BillingServices;

@Service
public class BillingServiceImpl implements BillingServices{


	@Autowired
	private BillingRepo billingRepo;
	
	@Override
	public List<BillingEntity> getAllBilling() {
		// TODO Auto-generated method stub
		return billingRepo.findAll();
	}

	@Override
	public Optional<BillingEntity> getBilling(int id)  throws BillingNotFoundException {
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				return billingRepo.findById(id);
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		
		}
	}

	@Override
	public BillingEntity addBilling(BillingEntity billingEntity) {
		// TODO Auto-generated method stub
		return billingRepo.save(billingEntity);
	}

	@Override
	public Optional<BillingEntity> deleteBilling(int id) throws BillingNotFoundException {
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				billingRepo.deleteById(id);
				return billingData;
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		}
	}

	@Override
	public BillingEntity updateBilling(int id, BillingEntity billingEntity) throws BillingNotFoundException {
		try {
			Optional<BillingEntity> billingData = billingRepo.findById(id);
			if(billingData!=null) {
				billingEntity.setId(id);
				return billingRepo.save(billingEntity);
			}
			else {
				throw new BillingNotFoundException("Billing Data not found");
			}
		}
		catch(Exception e){
			throw new BillingNotFoundException("Billing Data not found");
		
		}
	}
	

}
