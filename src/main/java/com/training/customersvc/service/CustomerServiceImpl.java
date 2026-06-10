package com.training.customersvc.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.customersvc.entity.Customer;
import com.training.customersvc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(long customerId) {
		Optional<Customer> obj = customerRepository.findById(customerId);
		if (obj.isPresent())	{
			return obj.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomerById(long customerId) {
		
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, long customerId) {
		//1. find the customer
		Optional<Customer> obj = customerRepository.findById(customerId);
		Customer oldCustomer = obj.get();
		//2. update the details
		oldCustomer.setCustomerName(customer.getCustomerName());
		oldCustomer.setCustomerEmail(customer.getCustomerEmail());
		//3. save the updated details
		customerRepository.save(oldCustomer);
		return oldCustomer;
		
	}

}
