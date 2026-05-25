package com.training.oops;

import java.util.Objects;

//Encapsulation
public class User{// implements Comparable<User>{
	
	// 1. attributes
	// instance variables
	protected String userId;
	protected String userName;
	protected String userEmail;
	protected int age;
	
	public User() {
		System.out.println("User constructor called");
	}
	
	//Constructor
	public User(String userId, String userName, String userEmail, int age) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.age = age;
	}
	
	//static variables
	static String organizationName;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", Age="+ age+"]";
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(userEmail, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(userEmail, other.userEmail) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	@Override
//	public int compareTo(User o) {
//		return this.userId.compareTo(o.userId);
//	}
	
	
	
	
	
	// 2. behaviour
	
	
	

}
