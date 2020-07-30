package com.dollarsbank.model;

public class Customer {
	private String name;
	private String address;
	private String contact_number;
	private String user_id;
	
	
	public Customer() {
	}

	public Customer(String name, String address, String contact_number, String user_id) {
		super();
		this.name = name;
		this.address = address;
		this.contact_number = contact_number;
		this.user_id = user_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Name = " + name + "\nAddress = " + address + "\nContact_number = " + contact_number + "\nUser Id = "
				+ user_id;
	}
	
	
	
}
