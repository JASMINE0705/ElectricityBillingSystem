package com.project.ElectricityBillingSystem.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name="customer")
public class CustomerEntity {
	
	@Id
//	@SequenceGenerator(name="CUSTOMER_SEQ_GEN", sequenceName="CUSTOMER_SEQ_GEN", allocationSize=1)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMER_SEQ_GEN")
	private int id;
	
	@NotNull(message = "full_name is mandatory")
	private String full_name;
	
	@NotNull(message = "mobile is mandatory")
	private String mobile;
	
	@Email(message = "Email should be valid")
	@NotNull(message = "email is mandatory")
	private String email;
	
	@OneToMany(targetEntity = BillingEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name="bill",referencedColumnName="id")
	private List<BillingEntity> bill;
	
	@OneToMany(targetEntity = PaymentEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name="payment",referencedColumnName="id")
	private List<PaymentEntity> payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service")
	private ServiceEntity service;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address")
	private AddressEntity address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login")
	private LoginEntity loginEntity;
	
	
//	@Positive (message = "bill_id should be greater than 0")
//	private int bill_id;
//	
//	@Positive (message = "service_id should be greater than 0")
//	private int service_id;
//	
//	@Positive (message = "payment_id should be greater than 0")
//	private int payment_id;
//	
//	@Positive (message = "address_id should be greater than 0")
//	private int address_id;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "billingEntity_id")
//	private BillingEntity billingEntity;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="customer_id")
//    private Set<AddressEntity> addressEntity;
	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(int cust_id, String full_name, String mobile, String email) {
		super();
		this.id = cust_id;
		this.full_name = full_name;
		this.mobile = mobile;
		this.email = email;
//		this.bill_id = bill_id;
//		this.service_id = service_id;
//		this.payment_id = payment_id;
//		this.address_id = address_id;
	}

	

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ServiceEntity getService() {
		return service;
	}

	public void setService(ServiceEntity service) {
		this.service = service;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoginEntity getLoginEntity() {
		return loginEntity;
	}

	public void setLoginEntity(LoginEntity loginEntity) {
		this.loginEntity = loginEntity;
	}

	public void setBill(List<BillingEntity> bill) {
		this.bill = bill;
	}

	public void setPayment(List<PaymentEntity> payment) {
		this.payment = payment;
	}

	public List<BillingEntity> getBill() {
		return bill;
	}

	public List<PaymentEntity> getPayment() {
		return payment;
	}

	
//
//	public int getAddress_id() {
//		return address_id;
//	}
//
//	public void setAddress_id(int address_id) {
//		this.address_id = address_id;
//	}
//
//	@Override
//	public String toString() {
//		return "CustomerEntity [cust_id=" + cust_id + ", full_name=" + full_name + ", mobile=" + mobile + ", email="
//				+ email + ", bill_id=" + bill_id + ", service_id=" + service_id + ", payment_id=" + payment_id
//				+ ", address_id=" + address_id + "]";
//	}

//	public BillingEntity getBillingEntity() {
//		return billingEntity;
//	}
//
//	public void setBillingEntity(BillingEntity billingEntity) {
//		this.billingEntity = billingEntity;
//	}

//	public Set<AddressEntity> getAddressEntity() {
//		return addressEntity;
//	}
//
//	public void setAddressEntity(Set<AddressEntity> addressEntity) {
//		this.addressEntity = addressEntity;
//	}
	
	
}
