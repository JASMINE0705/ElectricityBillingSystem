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
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="billing")
public class BillingEntity {
	
	@Id
	 @SequenceGenerator(name="BILLING_SEQ_GEN", sequenceName="BILLING_SEQ_GEN", allocationSize=1)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BILLING_SEQ_GEN")
	private int id;
	
	@Positive (message = "units_consumed is mandatory")
	private int units_consumed;
	
	@Positive (message = "amount is mandatory")
	private int amount;
	
	@NotNull(message = "due_date is mandatory")
	private String due_date;
	
	@NotNull(message = "start_date is mandatory")
	private String start_date;

	@NotNull(message = "end_date is mandatory")
	private String end_date;
	
//	@OneToOne(mappedBy = "billingEntity")
//	private CustomerEntity customerEntity;
	
	
	
	public BillingEntity() {
		super();
	}
	public BillingEntity(int id, int units_consumed, int amount, String due_date, String start_date,
			String end_date) {
		super();
		this.id = id;
		this.units_consumed = units_consumed;
		this.amount = amount;
		this.due_date = due_date;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnits_consumed() {
		return units_consumed;
	}
	public void setUnits_consumed(int units_consumed) {
		this.units_consumed = units_consumed;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "BillingEntity [id=" + id + ", customer_id=" + ", units_consumed=" + units_consumed
				+ ", amount=" + amount + ", due_date=" + due_date + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}
//	public CustomerEntity getCustomerEntity() {
//		return customerEntity;
//	}
//	public void setCustomerEntity(CustomerEntity customerEntity) {
//		this.customerEntity = customerEntity;
//	}
	
	

}
