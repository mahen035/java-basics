package com.training.java8;

@FunctionalInterface
public interface MyFunctionalInterface {
	
	int sum(int a, int b);

}

// Interface is 100% abstract
// all methods in an interface would be abstract.
// Functional interface: only one abstract method
// can have static and default methods
