package com.training.oops;

public class CurrentAccount extends Account{
	
	private double overdraftLimit;

	public CurrentAccount(int accountNumber, String customerName, double balance, double overdraftLimit) {
		super(accountNumber, customerName, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if(balance+overdraftLimit >= amount) {
			balance -= amount;
			System.out.println("Amount withdrawn from current account");
		}
		else {
			System.out.println("Exceeds Overdraft");
		}
	}
	
	

}
