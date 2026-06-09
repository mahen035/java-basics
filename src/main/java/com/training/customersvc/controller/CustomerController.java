package com.training.customersvc.controller;

import java.util.ArrayList;
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
		List<Customer> customers = new ArrayList<>();
		/*
		 * customers.add(new Customer("John Doe", "abc@mail.com")); customers.add(new
		 * Customer(2, "Sara", "xyz@mail.com")); customers.add(new Customer(3,
		 * "Abraham", "aaa@mail.com")); customers.add(new Customer(4, "Sayed",
		 * "acfdf@mail.com"));
		 */
		return customers;
	}
	
	@PostMapping("customer")
	public String addCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
		return "Customer added successfully";
	}
	
}
