package com.training.oops;

import java.util.Scanner;

public class UserClient {

	public static void main(String[] args) {
		//String name = "Ali";
		
		Admin admin = new Admin("Adm101","Anwar","bct@mail.com",23,true);
		System.out.println(admin);
//		Scanner sc = new Scanner(System.in);
//		System.out.println("How many user object you want:");
//		int count = Integer.parseInt(sc.nextLine());
//		User[] user = new User[count];
//		for(int i=0;i<count;i++) {
//			System.out.println("Enter user Id for user"+(i+1));
//			String userId=sc.nextLine();
//			System.out.println("Enter user name for user"+(i+1));
//			String userName=sc.nextLine();
//			System.out.println("Enter user email for user"+(i+1));
//			String userEmail=sc.nextLine();
//			user[i] = new User(userId, userName, userEmail);
//		}
//		
//		if(count >= 3) {
//			System.out.println(user[2]);
//		}
//		else {
//			System.out.println("There are less than 3 users");
//		}
//		
		
		
		User user1 = new User("A101","Haitham","abc@mail.com",21); 
//		user1.setUserId("A101");
//		user1.setUserName("Haitham");
//		user1.setUserEmail("abc@mail.com");
//		User.organizationName = "OAB";
//		User user2 = new User("A102","Abrar","xyz@gmail.com");
//		System.out.println(user1);
	}


}

// Take input from the user and create the user object with those values.

// Ask user how many user objects they want to create
// create those many user objects by taking values from the user
// display 3rd user's details

// Arrays : collection of similar data types

// Inheritance: IS A
// Association: HAS A





