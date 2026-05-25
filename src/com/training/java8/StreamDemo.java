package com.training.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.training.oops.User;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(5,2,6,7);
		//traditional way:
//		Collections.sort(numList);
//		for(int i:numList) {
//			int square = i*i;
//			System.out.println(square);
//		}
		Stream<Integer> numStream = numList.stream();
		numStream.filter(a->a%2!=0).map(n->n*n).sorted()
		         .forEach(x->System.out.println(x));
		
		
		List<User> userList = Arrays
				.asList(new User("A103","Abbas","abc@mail.com",21),
						new User("A105","Sara","abc@mail.com",23),
						new User("A101","Abdul","abc@mail.com",23),
						new User("A102","Anwar","abc@mail.com",21));
		
//		userList.stream().filter(usr->usr.getUserName()
//				.startsWith("A")).sorted((u1,u2)->u1.getUserId()
//						.compareTo(u2.getUserId()))
//						.forEach(u->System.out.println(u));
		
		userList.stream().filter(usr->usr.getUserName()
				.startsWith("A")).sorted(Comparator.comparing(User::getUserId))
						.forEach(System.out::println);
		System.out.println("==========Youngest User==========");
		User youngestUser = userList.stream()
			.sorted(Comparator.comparingInt(User::getAge))
			.findFirst().get();
		System.out.println(youngestUser);
		
		//min method
		User youngestUsr = userList.stream()
			.min(Comparator.comparingInt(User::getAge))
			.get();
		System.out.println(youngestUsr);
		
		System.out.println("==========Group By Age==========");
		
		Map<Integer,List<User>> userMap = userList.stream()
			.collect(Collectors.groupingBy(User::getAge));
		System.out.println(userMap);
		
		System.out.println("============Count by Age=======");
		
		Map<Integer,Long> userCount = userList.stream()
				.collect(Collectors.groupingBy(User::getAge,
						Collectors.counting())
						);
		System.out.println(userCount);
	}

}

//Stream API: To process collection in a single line
//1. Intermediate operations -> multiple
//2. Terminal operation -> single

// To process a collection:
	//1. Iterate the collection
 	//2. check for the condition
	//3. store the new collection
    //4. display or return the new collection

// Add a age field in your User class
// User Stream to show details for the youngest user
// max/min function; sort the user objects and then user findFirst() method

//1. Sort by age then by username
//2. Get top 3 olderst users
//3. Find sum of all ages
//4. Find average age for all users
//5. Check whether any user is below 18
