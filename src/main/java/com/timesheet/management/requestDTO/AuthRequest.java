package com.timesheet.management.requestDTO;

public class AuthRequest {
	private String empId;
	private String role;
	public String getUserName() {
		return empId;
	}
	public void setUserName(String userName) {
		this.empId = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}
