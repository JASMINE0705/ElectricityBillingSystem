package com.project.ElectricityBillingSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ElectricityBillingSystem.Entity.ServiceEntity;
import com.project.ElectricityBillingSystem.Exceptions.ServiceNotFoundException;
import com.project.ElectricityBillingSystem.Repository.ServiceRepo;
import com.project.ElectricityBillingSystem.Services.ServiceServices;

@Service
public class ServiceServiceImpl implements ServiceServices {

	@Autowired
	private ServiceRepo serviceRepo;
	
	@Override
	public List<ServiceEntity> getAllService() {
		// TODO Auto-generated method stub
		return serviceRepo.findAll();
	}

	@Override
	public Optional<ServiceEntity> getService(int id) throws ServiceNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				return serviceRepo.findById(id);
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		
		}	
	}

	@Override
	public ServiceEntity addService(ServiceEntity serviceEntity) {
		// TODO Auto-generated method stub
		return serviceRepo.save(serviceEntity);
	}

	@Override
	public Optional<ServiceEntity> deleteService(int id) throws ServiceNotFoundException {
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				serviceRepo.deleteById(id);
				return serviceData;
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		}
	}

	@Override
	public ServiceEntity updateService(int id, ServiceEntity serviceEntity) throws ServiceNotFoundException {
		try {
			Optional<ServiceEntity> serviceData = serviceRepo.findById(id);
			if(serviceData!=null) {
				serviceEntity.setId(id);
				return serviceRepo.save(serviceEntity);
			}
			else {
				throw new ServiceNotFoundException("Service Data not found");
			}
		}
		catch(Exception e){
			throw new ServiceNotFoundException("Service Data not found");
		
		}	
	}

}
