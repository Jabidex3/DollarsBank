package com.dollarsbank.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

public class DollarsBankController {
	private List<Customer> userList;
	private List<Account> accList;
	private int currentUserIndex =0;
	
	
	//customer list with test data
	private String[] u_name = {"Homer Simpson", "Jon Snow", "Walter White", "Wolverine"};
	private String[] address = {"United States", "Westeros", "United States", "Canada"};
	private String[] phone = {"7185557788", "3472232255", "9298245678", "2124201996"};
	private String[] uid = {"U01","U02","U03","U04"};
	
	//account list with test data
	private String[] pass = {"Password123!","UnsafePW24@","WooHoo#36","!actualPass43"};
	private double[] bal = {500,4000,3200,20000};
	
	public DollarsBankController() {
		userList = new ArrayList<Customer>();
		for (int i = 0; i < address.length; i++) {
			Customer c = new Customer();
			c.setName(u_name[i]);
			c.setAddress(address[i]);
			c.setContact_number(phone[i]);
			c.setUser_id(uid[i]);
			userList.add(c);
		}
		
		accList = new ArrayList<Account>();
		for (int i = 0; i < uid.length; i++) {
			accList.add(new Account(uid[i],pass[i],bal[i]));
		}
	}
	
	//checks if user id is available
	public void createUser(String name, String address, String num, String id) {
		for(int i =0;i< userList.size();i++) {
			if(userList.get(i).getUser_id().equals(id)) {
				System.out.println("user id not available. enter a new one");
			}
			else {
				userList.add(new Customer(name,address,num,id));
			}
		}
	}
	
	public void getUserListInfo() {
		for(Customer c:userList) {
			System.out.println(c);
			System.out.println();
		}
		
	}
	public void getAccListInfo() {
		for(Account a:accList) {
			System.out.println(a);
			System.out.println();
		}
		
	}
	
	public void addCustomer(Customer c){
		userList.add(c);
	}
	
	//login
	public boolean checkCredentials(String entered_id,String entered_pw) {
		for(int i =0;i< userList.size();i++) {
			if(userList.get(i).getUser_id().equals(entered_id)) {
				for(int j =0;j< accList.size();j++) {
					if(accList.get(j).getUser_id().equals(entered_id)) {
						if(accList.get(j).getPassword().equals(entered_pw)) {
							currentUserIndex = i;
							return true;
						}
				}
			}
		}
	}
		return false;
	}
	
	public void addAcc(Account a){
		accList.add(a);
	}
	
	
	
	public boolean deposit(double amt) {
		accList.get(currentUserIndex).setBalance(accList.get(currentUserIndex).getBalance()+amt);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		accList.get(currentUserIndex).setTransactions("Deposit Amount "+ amt+ " in account ["+accList.get(currentUserIndex).getUser_id()+"]. Balance - "+ accList.get(currentUserIndex).getBalance() +" as on "+ timestamp);
		return true;
	}
	
	public String currBalance() {
		return String.valueOf(accList.get(currentUserIndex).getBalance());
	}
	
	public boolean withdraw(double amt) {
		if(amt>accList.get(currentUserIndex).getBalance()) {
			return false;
		}
		else {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			accList.get(currentUserIndex).setBalance(accList.get(currentUserIndex).getBalance()-amt);
			accList.get(currentUserIndex).setTransactions("Withdraw Amount "+ amt+ " from account ["+accList.get(currentUserIndex).getUser_id()+"]. Balance - "+ accList.get(currentUserIndex).getBalance() +" as on "+ timestamp);
			return true;
		}
		
	}
	
	//prints out customer information
	public void customerInfo() {
		System.out.println(userList.get(currentUserIndex));
		System.out.println(accList.get(currentUserIndex));
	}
	
	public void recentTransactions() { //recent on top; old on bottom
		ArrayList<String> currTransactions = accList.get(currentUserIndex).getTransactions();
		if(currTransactions.size()>5) {
			int ctr = 1;
			for(int i=currTransactions.size()-1;i>=currTransactions.size()-5;i--) {
				System.out.println(ctr +". " +currTransactions.get(i));
				ctr++;
			}
		}
		else {
			int ctr2 = 1;
			for(int j= currTransactions.size()-1;j>=0;j--) {
				System.out.println(ctr2 +". " +currTransactions.get(j));
				ctr2++;
			}
		}
		
	}
}
