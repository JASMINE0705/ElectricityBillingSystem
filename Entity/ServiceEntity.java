package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Entity
@Table(name="Service")
public class ServiceEntity {
	
	@Id
	@SequenceGenerator(name="SERVICE_SEQ_GEN", sequenceName="SERVICE_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SERVICE_SEQ_GEN")
	private int id;
	
	@NotNull(message = "service_type is mandatory")
	private String service_type ;
	
	
	public ServiceEntity() {
		super();
	}

	public ServiceEntity(int id, String service_type) {
		super();
		this.id = id;
		this.service_type = service_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	@Override
	public String toString() {
		return "ServiceEntity [id=" + id + ", service_type=" + service_type + ", cust_id="  + "]";
	}
	
	
	
}
