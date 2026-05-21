package com.training;

//Encapsulation
public class User{
	
	// 1. attributes
	// instance variables
	protected String userId;
	protected String userName;
	protected String userEmail;
	
	public User() {
		System.out.println("User constructor called");
	}
	
	//Constructor
	public User(String userId, String userName, String userEmail) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
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
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}
	
	
	
	
	// 2. behaviour
	
	
	

}
