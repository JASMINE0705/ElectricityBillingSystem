package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="admin")
public class AdminEntity {
	
	@Id
	//@SequenceGenerator(name="ADMIN_SEQ_GEN", sequenceName="ADMIN_SEQ_GEN", allocationSize=1)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADMIN_SEQ_GEN")
	private int id;
	
	@NotNull(message = "admin_name is mandatory")
	private String admin_name;
	
	@NotNull(message = "admin_contact is mandatory")
	private String admin_contact;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login")
	private LoginEntity loginEntity;
	
	public AdminEntity() {
		super();
	}
	public AdminEntity(int id, String admin_name, String admin_contact) {
		super();
		this.id = id;
		this.admin_name = admin_name;
		this.admin_contact = admin_contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_contact() {
		return admin_contact;
	}
	public void setAdmin_contact(String admin_contact) {
		this.admin_contact = admin_contact;
	}
	@Override
	public String toString() {
		return "AdminEntity [id=" + id + ", admin_name=" + admin_name + ", admin_contact=" + admin_contact + "]";
	}
	public LoginEntity getLoginEntity() {
		return loginEntity;
	}
	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}
	
	
}
