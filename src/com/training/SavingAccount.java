package com.training;

public class SavingAccount extends Account{
	
	private float interestRate = 4.5f;
	
	public SavingAccount(int accountNumber, String customerName, 
			             double balance, float interestRate) {
		super(accountNumber, customerName, balance);
		this.interestRate = interestRate;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	public void addInterest() {
		double interest = (balance * interestRate)/100;
		balance += interest;
		System.out.println(interest+ ":Interest added to the balance");
	}
	
	//Overloading--static polymorphism
	public void addInterest(double interestRate) {
		double interest = (balance * interestRate)/100;
		balance += interest;
		System.out.println(interest+ ":Interest added to the balance");
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException{
		if(amount < balance) {
			balance -= amount;
			System.out.println(amount+" got withdrawn successfully in your account"); 
		}
		else { 
			
			throw new InsufficientBalanceException("Insufficient balance");	
			
			//System.out.println("Insufficient balance");
		}
		
	}
}
