package com.training.customersvc.service;
import java.util.List;
import com.training.customersvc.entity.Customer;

public interface CustomerService {
	
	void addCustomer(Customer customer);
	List<Customer> getAllCustomers();
	Customer getCustomerById(long customerId);
	void deleteCustomerById(long customerId);
	Customer updateCustomer(Customer customer, long customerId);

}
