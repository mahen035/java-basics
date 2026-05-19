package com.training;
import java.util.Scanner;
public class Customer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name:");
		String customerName = sc.nextLine();
		//next() -> will take single string without space
		//nextInt() -> to input integer values
		byte b = 112;
		short s = 115;
		//s = b;
		
		System.out.println("Customer class");
		System.out.println("Customer Name: "+customerName);
	}
}
// import shortcut: ctrl+shift+o
//Java is a strongly typed language
// variable is a placeholder pointing to a memory location

// create variables that will store customer first name,
// customer last name, customer age.
// and display all the customer details in a single line

// Take the customer details from user using scanner class
// check if the customer is more than 18 then display 
// Eligible to open an account
// else display: Not yet eligible to open an account.



// Things to cover today:
	// Scanner
	// conditions
	// loops
