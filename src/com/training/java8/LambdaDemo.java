package com.training.java8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {

	public static void main(String[] args) {
		//System.out.println(sum(9,8));
		MyFunctionalInterface obj = (x,y)->x+y;
		System.out.println(obj.sum(4, 6));
		
		Predicate<Integer> p =(a)->a%2 == 0;
		System.out.println(p.test(12));
		
		Predicate<String> stringLength = str->str.length()>5;
		stringLength.test("hello world");
		
		//Consumer
		Consumer<Integer> c = y->System.out.println(y*10);
		c.accept(5);
		
		List<Integer> numList = Arrays.asList(2,5,6,7);
		
		numList.forEach(a->System.out.println(a));
		
		//Supplier
		Supplier<LocalDate> today = ()->LocalDate.now();
		System.out.println(today.get());
		
		//Function
		Function<String, String> upper = str->str.toUpperCase();
		System.out.println(upper.apply("hello"));
		
	}
//	static int sum(int x, int y) {
//		return x+y;
//	}
	//Lambda:
	
	

}
// Lambda is a replacement for a method
// Return type of lambda is a functional interface

// create a lambda to check whether a string length is 
// greater than 5 or not

// Create one object of User class and display the
// details using Consumer interface