package com.training.customersvc.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.training.customersvc.dto.RegisterRequest;
import com.training.customersvc.dto.RegisterResponse;
import com.training.customersvc.entity.Customer;
import com.training.customersvc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(UUID customerId) {
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
	public void deleteCustomerById(UUID customerId) {
		
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public Customer updateCustomer(Customer customer, UUID customerId) {
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

	@Override
	public RegisterResponse registerCustomer(RegisterRequest request) {
				
		Customer newCustomer = customerRepository.save(
					new Customer(request.getCustomerName(), 
								 request.getCustomerEmail(),
								 passwordEncoder.encode(request.getPassword())));
		//passwordEncoder.matches(null, null)
		
		RegisterResponse response = new RegisterResponse(newCustomer.getCustomerId(), 
				                                        "Registration Successful!");
		return response;
	}

}
