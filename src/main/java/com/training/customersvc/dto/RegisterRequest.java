package com.training.customersvc.dto;

public class RegisterRequest {
	
	private String customerName;
	private String customerEmail;
	private String password;
	
	public RegisterRequest() {
		super();
	}

	public RegisterRequest(String customerName, String customerEmail, String password) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.password = password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
