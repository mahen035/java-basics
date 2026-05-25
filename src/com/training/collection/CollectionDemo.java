package com.training.collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.training.oops.User;

import java.util.Set;
import java.util.TreeSet;
public class CollectionDemo {
	public static void main(String[] args) {
		Set<String> names = new TreeSet<>();
		names.add(new String("Zara"));
		names.add(new String("Tina"));
		names.add(new String("Sayeed"));
		names.add(new String("Tina"));
		//names.add(23); //Integer -- Autoboxing
		Iterator it = names.iterator();
		while(it.hasNext()) {
			String name = (String)it.next();
			System.out.println(name);
		}
		
		Set<User> userSet = new TreeSet<>(new NameComparator());
		//List<User> userList = new ArrayList<>();
		User user1 = new User("A101","Gaith", "abc@mail.com");
		User user2 = new User("A102","Anwar", "sdf@mail.com");
		User user4 = new User("A104","Rohan", "rho@mail.com");
		User user3 = new User("A103","Ayuub", "gjf@mail.com");
		User user5 = new User("A102","Anwar", "sdf@mail.com");
		userSet.add(user1);
		userSet.add(user2);
		userSet.add(user4);
		userSet.add(user3);
		//.args..add(user5);
		//Collections.sort(userList, new NameComparator());;
		for(User user:userSet) {
			System.out.println(user);
		}
		
		Map<Integer,String> namesMap = new HashMap<>();
		
		namesMap.put(101, "Sara");
		namesMap.put(102, "Ibrahim");
		namesMap.put(103, "Sayyed");
		namesMap.put(104, "Zubaida");
		
		System.out.println(namesMap.get(103));
		
		for(Entry<Integer, String> entry:namesMap.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}
}

// Generics
