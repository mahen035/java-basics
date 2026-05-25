package com.training.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		int x = 0;
		int y=1;
		try {
			y = 8/x;
		}
		catch(ArithmeticException | NumberFormatException e) {
			System.out.println("ArithmeticException caught");
		}
//		catch(NumberFormatException e) {
//			System.out.println("NumberformatException caught");
//		}
		finally {
			System.out.println("Finally block");
		}
		
		System.out.println("Value of y is:"+y);
	}

}
