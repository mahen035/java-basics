package com.training.oops;

public class Admin extends User{
	
	private boolean isSuperAdmin;
	
	public Admin(String userId, String userName, String userEmail,int age, boolean isSuperAdmin) {
		super(userId, userName, userEmail,age);
		this.isSuperAdmin=isSuperAdmin;
	}

	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	@Override
	public String toString() {
		return "Admin [isSuperAdmin=" + isSuperAdmin + ", userId=" + userId + ", userName=" + userName + ", userEmail="
				+ userEmail + "]";
	}
	
	

}
