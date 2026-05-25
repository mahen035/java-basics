package com.training.collection;

import java.util.Comparator;

import com.training.oops.User;

public class NameComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return o1.getUserName().compareTo(o2.getUserName());
	}

}
