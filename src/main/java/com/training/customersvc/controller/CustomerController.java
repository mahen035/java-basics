package com.training.customersvc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.customersvc.dto.Account;
import com.training.customersvc.dto.RegisterRequest;
import com.training.customersvc.dto.RegisterResponse;
import com.training.customersvc.entity.Customer;
import com.training.customersvc.intercomm.AccountClient;
import com.training.customersvc.service.CustomerService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountClient accountClient;
	
	@GetMapping
	public String greet() {
		return "Hello from Customer Service";
	}
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		//return customerService.getAllCustomers();
		return ResponseEntity.ok(customerService.getAllCustomers());
		
	}
	
	
	@PostMapping("register")
	public ResponseEntity<RegisterResponse> registerCustomer(@RequestBody RegisterRequest request) {
		RegisterResponse response = customerService.registerCustomer(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("customer")
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer, @RequestParam String accountType, @RequestParam double balance) {
		customerService.addCustomer(customer);
		Account account = new Account();
		account.setCustomerId(customer.getCustomerId());
		account.setBalance(balance);
		account.setAccountType(accountType);
		accountClient.addAccount(account);
		//System.out.println("Customer ID: "+customer.getCustomerId());
		//return "Customer added successfully";
		return new ResponseEntity<>("Customer added successfully",HttpStatus.CREATED);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<Customer> findById(@PathVariable("id") UUID customerId) {
		//return customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customerService.getCustomerById(customerId),HttpStatus.FOUND);
	}
	
	@DeleteMapping("customer")
	public ResponseEntity<String> deleteById(@RequestParam UUID cutomerId) {
		customerService.deleteCustomerById(cutomerId);
		//return "Customer Deleted Successfully!";
		return new ResponseEntity<>("Customer Deleted Successfully!",HttpStatus.OK);
	}
	
	@PutMapping("customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") UUID customerId) {
		//return customerService.updateCustomer(customer, customerId);
		return new ResponseEntity<>(customerService.updateCustomer(customer, customerId),HttpStatus.OK);
	}
	
}

//CRUD:
