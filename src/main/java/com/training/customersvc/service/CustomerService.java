package com.training.customersvc.service;
import java.util.List;
import java.util.UUID;

import com.training.customersvc.dto.RegisterRequest;
import com.training.customersvc.dto.RegisterResponse;
import com.training.customersvc.entity.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(UUID customerId);
	void deleteCustomerById(UUID customerId);
	Customer updateCustomer(Customer customer, UUID customerId);
	RegisterResponse registerCustomer(RegisterRequest request);

}
