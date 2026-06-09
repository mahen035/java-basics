package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer {
	
	private String name;
	private String email;
	private int age;
	
	@Autowired
	private Account account;
	
	public Customer() { super(); }
	 
	public Customer(int age) {
		super();
		this.age = age;
	}

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	
	  public void setEmail(String email) { this.email = email; }


	  public int getAge() {
		  return age;
	  }


	  public void setAge(int age) {
		  this.age = age;
	  }

	  public Account getAccount() {
		  return account;
	  }

	  public void setAccount(Account account) {
		  this.account = account;
	  }
	  
	  public String customerDetails() {
		  return "Customer [name=" + name + ", email=" + email + ", age=" + age + "]"+account.accountDetails();
	  }
	 

}
