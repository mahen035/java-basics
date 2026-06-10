package com.training.customersvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.customersvc.entity.Customer;
import com.training.customersvc.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public String greet() {
		System.out.println("Inside CustomerController.greet()");
		return "Hello from Customer Service";
	}
	
	@GetMapping("customer")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
		
	}
	
	@PostMapping("customer")
	public String addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return "Customer added successfully";
	}
	
	@GetMapping("customer/{id}")
	public Customer findById(@PathVariable("id") long customerId) {
		return customerService.getCustomerById(customerId);
	}
	
	@DeleteMapping("customer")
	public String deleteById(@RequestParam long cutomerId) {
		customerService.deleteCustomerById(cutomerId);
		return "Customer Deleted Successfully!";
	}
	
	@PutMapping("customer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") long customerId) {
		return customerService.updateCustomer(customer, customerId);
	}
	
}

//CRUD:
