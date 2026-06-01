package com.training.io;

import java.io.Serializable;

public class Customer implements Serializable{//Marker Interface
	 
	private static final long serialVersionUID = 3564575578648288579L;

	private String customerId;
	private String customerName;
	private String gender;
	private String city;
	//Constructor
	public Customer(String customerId, String customerName, String gender, String city) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.city = city;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", city=" + city + "]";
	}

}
