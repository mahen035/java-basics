package com.training;

public abstract class Account {
	
	protected int accountNumber;
	protected String customerName;
	protected double balance;
	
	public Account(int accountNumber, String customerName, double balance) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	//deposit
	public void deposit(double amount) {
		balance += amount; //balance = balance+amount
		System.out.println(amount+" got deposited successfully in your account"); 
	}
	
	//withdraw
//	public void withdraw(double amount) {
//		if(amount < balance) {
//			balance -= amount;
//			System.out.println(amount+" got withdrawn successfully in your account"); 
//		}
//		else {
//			System.out.println("Insufficient balance");
//		}
//		
//	}
	
	public abstract void withdraw(double amount) throws InsufficientBalanceException;
	
	public double displayBalance() {
		return balance;
	}

}

//Abstract method: No implementation
//Concrete method: having implementation

//Interface: 100% abstract - explore interface
