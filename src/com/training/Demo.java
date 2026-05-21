package com.training;
import java.util.Scanner;
public class Demo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0; //initialization
		while(true) { // condition
			System.out.println("Enter X to exit or any other key to continue");
			String choice = sc.nextLine();
			if(choice.equalsIgnoreCase("X")) {
				break;
			}
			i++; // increment
			
			System.out.println("Enter first name for customer:"+i );
			sc.nextLine();
			System.out.println("Enter last name for customer:"+i );
			sc.nextLine();
			System.out.println("Enter age for customer:"+i );
			sc.nextLine().charAt(0);
			
		}
		System.out.println("Total number of customers saved: "+i);
		
		for(int j = 0; j<3;j++) {
			System.out.println("Number of iteration:"+ j+1);
		}
		
		int k = 0;
		do {
			System.out.println("Inside do while loop");
			k++;
		}while(k<3);
		
		//System.out.println("Enter customer name:");
		//String customerName = sc.nextLine();
		//next() -> will take single string without space
		//nextInt() -> to input integer values
		byte b = 112;
		short s = 116;
		//s = b;
		
		/*
		 * System.out.println("Customer class update");
		 * System.out.println("Customer Name: "+customerName);
		 */
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

// Exception handling
