package com.project.ElectricityBillingSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="address")
public class AddressEntity {

	@Id
	@SequenceGenerator(name="ADD_SEQ_GEN", sequenceName="ADD_SEQ_GEN", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADD_SEQ_GEN")
	private int id;
	
	@NotNull(message = "d_no is mandatory")
	private String d_no;

	@NotNull(message = "street is mandatory")
	private String street;

	@NotNull(message = "city is mandatory")
	private String city;
	
	@NotNull(message = "state is mandatory")
	private String state;
	
	public AddressEntity() {
		super();
	}
	public AddressEntity(int id, String d_no, String street, String city, String state) {
		super();
		this.id = id;
		this.d_no = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getD_no() {
		return d_no;
	}
	public void setD_no(String d_no) {
		this.d_no = d_no;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", d_no=" + d_no + ", street=" + street + ", city=" + city + ", state="
				+ state + "]";
	}
	
	
}
