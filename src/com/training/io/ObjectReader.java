package com.training.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectReader {

	public static void main(String[] args) {
		
		try(ObjectInputStream ois = new ObjectInputStream
									(new FileInputStream("customer.ser"))){
			
			Customer cust =(Customer)ois.readObject();
			System.out.println(cust.getCustomerName());
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
