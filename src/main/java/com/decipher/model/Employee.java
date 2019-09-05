package com.decipher.model;

public class Employee {

	private String Username;
	private String Address;
	private String rollNumber;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	  @Override public String toString() { return "Student [name=" + Username +
	  ", address=" + Address + ", rollNumber=" + rollNumber + "]"; }
	 
}
