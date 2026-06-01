package com.training.bank;
public class Account {
	
	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
		
	}
	public double displayBalance() {
		return balance;
	}
	
	public void withdraw(double amount) {
		if(amount >= balance) {
			throw new IllegalArgumentException();
		}
		else {
			balance -= amount;
		}
		
	}
	
	

}
