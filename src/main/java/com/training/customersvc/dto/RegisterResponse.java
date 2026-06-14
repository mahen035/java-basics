package com.training.customersvc.dto;

import java.util.UUID;

public class RegisterResponse {
	
	private UUID customerId;
	private String message;
	
	public RegisterResponse() {
		super();
	}
	public RegisterResponse(UUID customerId, String message) {
		super();
		this.customerId = customerId;
		this.message = message;
	}
	public UUID getCustomerId() {
		return customerId;
	}
	public void setCustomerId(UUID customerId) {
		this.customerId = customerId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
