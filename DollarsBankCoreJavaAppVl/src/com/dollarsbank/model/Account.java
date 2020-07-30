package com.dollarsbank.model;

import java.util.ArrayList;
import java.sql.Timestamp;

public class Account {
	private String user_id;
	private String password;
	private double balance;
	private ArrayList<String> transactions;
	
	public Account() {
		
	}
	
	public Account(String user_id, String password, double balance) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.balance = balance;
		this.transactions = new ArrayList<String>();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		transactions.add("Initial Deposit Amount in account ["+this.user_id+"]. Balance - "+ this.balance +" as on "+ timestamp);
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
//		if(transactions.size()<6) {
//			return transactions;
//		}
//		else {
//			int size = transactions.size();
//			return (ArrayList<String>) transactions.subList(size-5, size);
//		}
		
	}

	public void setTransactions(String transaction) {
		this.transactions.add(transaction);
	}

	@Override
	public String toString() {
		return "Password = " + password + "\nBalance = " + balance + "\nTransactions = " 
				+ transactions + "]";
	}
	
	
	
	
	
}
