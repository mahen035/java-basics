package com.training;

public class Admin extends User{
	
	private boolean isSuperAdmin;
	
	public Admin(String userId, String userName, String userEmail, boolean isSuperAdmin) {
		super(userId, userName, userEmail);
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
