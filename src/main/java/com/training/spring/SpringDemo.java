package com.training.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.spring.config.AppConfig;

public class SpringDemo {

	public static void main(String[] args) {
		
		/*
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("ApplicationContext.xml");
		 * 
		 * 
		 */
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Customer customer1 = (Customer)context.getBean(Customer.class);
		System.out.println(customer1.customerDetails());
//		Customer customer2 = (Customer)context.getBean("customerId");
//		customer2.setEmail("test@mail.com");
//		System.out.println(customer1.getEmail());

	}

}
