package com.project.ElectricityBillingSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.project.ElectricityBillingSystem.Entity.BillingEntity;
import com.project.ElectricityBillingSystem.Exceptions.BillingNotFoundException;

@Service
public interface BillingServices {

	public List<BillingEntity> getAllBilling();
	
	public Optional<BillingEntity> getBilling(int id) throws BillingNotFoundException;
	
	public BillingEntity addBilling(BillingEntity billingEntity);
	
	public Optional<BillingEntity> deleteBilling(int id) throws BillingNotFoundException;
	
	public BillingEntity updateBilling(int id, BillingEntity billingEntity) throws BillingNotFoundException;
}
