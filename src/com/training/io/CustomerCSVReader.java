package com.training.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CustomerCSVReader {
	public static void main(String[] args) throws IOException{

		try(BufferedReader br = new BufferedReader
								(new FileReader("customer.csv"));
			BufferedWriter bw = new BufferedWriter
								(new FileWriter("male_customer.csv"));
			ObjectOutputStream oos = new ObjectOutputStream(
								 new FileOutputStream("customer.ser"))) 
			
		{
			bw.write("customer_id, customer_name, gender, city");
			bw.newLine();
			br.readLine(); //skip the header
			String line;
			while((line = br.readLine()) != null) {
				//line="C101,Sara,Female,Muscat"
				String[] data = line.split(",");
				Customer customer = new Customer(data[0],
												data[1],
												data[2],
												data[3]);
				System.out.println(customer);
				oos.writeObject(customer);
				if(data[2].equalsIgnoreCase("male")) {
					bw.write(data[0]+","+data[1]+","+data[2]+","+data[3]);
					bw.newLine();
				}
				
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File is not available or incorrect");
			e.printStackTrace();
		}

	}

}

// try with resources
