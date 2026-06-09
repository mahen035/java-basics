package com.training.customersvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
     //@Configuration
	 //@EnableAutoConfiguration
	 //@ComponentScan(basePackages = "com.training.customersvc")
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

}
