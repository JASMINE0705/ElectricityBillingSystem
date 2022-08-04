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
@Table(name="payment")
public class PaymentEntity {

	@Id
	@SequenceGenerator(name="PAYMENT_SEQ_GEN", sequenceName="PAYMENT_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAYMENT_SEQ_GEN")
	private int id;

	@NotNull(message = "payment_type is mandatory")
	private String payment_type ;
	
	@NotNull(message = "amount is mandatory")
	private int amount;
	
	public PaymentEntity() {
		super();
	}

	public PaymentEntity(int id, String payment_type, int customer_id) {
		super();
		this.id = id;
		this.payment_type = payment_type;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentEntity [id=" + id + ", payment_type=" + payment_type + ", amount=" + amount + "]";
	}

	
}
