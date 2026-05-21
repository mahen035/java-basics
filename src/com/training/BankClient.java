package com.training;
public class BankClient {
	public static void main(String[] args) {
		SavingAccount savingAccount = new SavingAccount(1234, 
				                     "Anwar", 500, 4);
		System.out.println("Before deposit:"+savingAccount.displayBalance());
		savingAccount.deposit(300);
		System.out.println("After deposit:"+savingAccount.displayBalance());
		savingAccount.withdraw(100);
		System.out.println("After withdraw:"+savingAccount.displayBalance());
		savingAccount.addInterest();
		System.out.println("After adding interest:"+savingAccount.displayBalance());
		
		//dynamic polymorphism
		Account currentAccount = new CurrentAccount(
									2781,"Hassan",400,100);
		currentAccount.deposit(500);
		currentAccount.withdraw(1050);
		System.out.println("After withdraw:"+currentAccount.displayBalance());
	}
}

//Method overloading:
// Same method name but different parameter list
