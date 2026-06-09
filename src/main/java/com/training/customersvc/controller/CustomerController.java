package com.training.customersvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.customersvc.entity.Customer;
import com.training.customersvc.repository.CustomerRepository;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;

	@GetMapping
	public String greet() {
		System.out.println("Inside CustomerController.greet()");
		return "Hello from Customer Service";
	}
	
	@GetMapping("customer")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
		
	}
	
	@PostMapping("customer")
	public String addCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "Customer added successfully";
	}
	
}

//CRUD
