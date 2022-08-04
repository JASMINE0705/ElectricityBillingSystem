package com.project.ElectricityBillingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ElectricityBillingSystem.Entity.CustomerEntity;

@Repository
public interface CustomerRepo   extends JpaRepository<CustomerEntity,Integer>  {

}
