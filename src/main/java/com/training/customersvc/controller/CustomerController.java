package com.training.customersvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Customer>> getAllCustomers() {
		//return customerService.getAllCustomers();
		return ResponseEntity.ok(customerService.getAllCustomers());
		
	}
	
	@PostMapping("customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		//return "Customer added successfully";
		return new ResponseEntity<>("Customer added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> findById(@PathVariable("id") long customerId) {
		//return customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.FOUND);
	}
	
	@DeleteMapping("customer")
	public ResponseEntity<String> deleteById(@RequestParam long cutomerId) {
		customerService.deleteCustomerById(cutomerId);
		//return "Customer Deleted Successfully!";
		return new ResponseEntity<>("Customer Deleted Successfully!",HttpStatus.OK);
	}
	
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") long customerId) {
		//return customerService.updateCustomer(customer, customerId);
		return new ResponseEntity<>(customerService.updateCustomer(customer, customerId),HttpStatus.OK);
	}
	
}

//CRUD:
