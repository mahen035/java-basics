package com.training.spring.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.training.spring.Account;
import com.training.spring.Customer;

@Configuration
public class AppConfig {
	
	@Bean
	Customer customer() {
		Customer customer = new Customer();
		customer.setName("John Doe");
		customer.setEmail("abc@mail.com");
		customer.setAge(30);
		return customer;
	}
	
	@Bean
	Account account() {
		Account account = new Account();
		account.setAccountNumber("123456789");
		account.setBalance(1000.0);
		account.setAccountType("Savings");
		return account;
	}

}
