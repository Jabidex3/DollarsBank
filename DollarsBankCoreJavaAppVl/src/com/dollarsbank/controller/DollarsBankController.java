package com.dollarsbank.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

public class DollarsBankController {
	private List<Customer> userList;
	private List<Account> accList;
	private int currentUserIndex = 0;	
	
	public DollarsBankController() {
		//populating lists with the test data
		userList = new ArrayList<Customer>();
		for (int i = 0; i < DataGeneratorStubUtil.address.length; i++) {
			Customer c = new Customer();
			c.setName(DataGeneratorStubUtil.u_name[i]);
			c.setAddress(DataGeneratorStubUtil.address[i]);
			c.setContact_number(DataGeneratorStubUtil.phone[i]);
			c.setUser_id(DataGeneratorStubUtil.uid[i]);
			userList.add(c);
		}
		
		accList = new ArrayList<Account>();
		for (int i = 0; i < DataGeneratorStubUtil.uid.length; i++) {
			accList.add(new Account(DataGeneratorStubUtil.uid[i],DataGeneratorStubUtil.pass[i],DataGeneratorStubUtil.bal[i]));
		}
	}
	

	//lists customer information of all users of the bank
	public void getUserListInfo() {
		for(Customer c:userList) {
			System.out.println(c);
			System.out.println();
		}
		
	}
	
	//lists account info of all users
	public void getAccListInfo() {
		for(Account a:accList) {
			System.out.println(a);
			System.out.println();
		}
		
	}
	
	//checks if user id entered by user is available
	public boolean checkUserId(String id) {
		for(int i =0;i< userList.size();i++) {
			if(userList.get(i).getUser_id().equals(id)) {
				return false; //unavailable
			}
		}
		return true;//available
	}
	
	//checks if contact number is a valid number
	public boolean validnum(String n) {
		if( n.length()!=10) {
			return false;
		}
		
		try {
			 double num = Double.parseDouble(n);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	//checks if password entered by user meets certain criteria
	public boolean checkPassValidity(String pw) {
		boolean hasUpper = false;
		boolean hasLower = false;
		boolean hasSpecial = false;
		if(pw.length()<8) {
			return false;
		}
		
		for(int i =0;i<pw.length();i++) {
			if(Character.isUpperCase(pw.charAt(i))){
				hasUpper=true;
			}
			if(Character.isLowerCase(pw.charAt(i))){
				hasLower=true;
			}
		}
		
		Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	    Matcher m = special.matcher(pw);
	    if(m.find()) {
	    	hasSpecial = true;
	    }
	    
	    if(hasUpper && hasLower && hasSpecial) {
	    	return true;
	    }
	    return false;
	}
		
	//add's new user
	public void addCustomer(Customer c){
		userList.add(c);
	}
	
	//login check
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
	
	//creates new account for a newly registered user
	public void addAcc(Account a){
		accList.add(a);
	}
	
	//deposit money into user's account
	public boolean deposit(double amt) {
		accList.get(currentUserIndex).setBalance(accList.get(currentUserIndex).getBalance()+amt);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		accList.get(currentUserIndex).setTransactions("Deposit Amount "+ amt+ " in account ["+accList.get(currentUserIndex).getUser_id()+"]. Balance - "+ accList.get(currentUserIndex).getBalance() +" as on "+ timestamp);
		return true;
	}
	
	//returns current balance of the user
	public String currBalance() {
		return String.valueOf(accList.get(currentUserIndex).getBalance());
	}
	
	//withdraws money from the user's account
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
	
	//check if amount entered for money transfer is valid
	public boolean transferCheck(double amt) {
		if(amt>accList.get(currentUserIndex).getBalance()) {
			return false;
		}
		return true;
	}
	
	//check if uid entered for money transfer is valid
	public boolean transferCheckId(String id) {
		boolean validPerson = false;
		
		for(int i =0;i< userList.size();i++) {
			if(userList.get(i).getUser_id().equals(id) && i!=currentUserIndex) {
				validPerson =true;
				break;
			}
		}
		
		return validPerson;
	}
	
	//transfer money from user acc to other acc
	public boolean transfer(String id, double amt) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		//update user balance
		accList.get(currentUserIndex).setBalance(accList.get(currentUserIndex).getBalance()-amt);
		//add to transaction list
		accList.get(currentUserIndex).setTransactions("Money Transfer Amount "+ amt+ " from account ["+accList.get(currentUserIndex).getUser_id()+"] to "+id+". Balance - "+ accList.get(currentUserIndex).getBalance() +" as on "+ timestamp);
		
		int recieverIndex =-1;
		for(int i =0;i< userList.size();i++) {
			if(userList.get(i).getUser_id().equals(id)) {
				recieverIndex=i;
				break;
			}
		}
		
		//update reciever balance
		accList.get(recieverIndex).setBalance(accList.get(recieverIndex).getBalance()+amt);
		//add to reciever transaction list
		accList.get(recieverIndex).setTransactions("Money Transfer Amount "+ amt+ " recieved from account ["+accList.get(currentUserIndex).getUser_id()+"]. Balance - "+ accList.get(recieverIndex).getBalance() +" as on "+ timestamp);
		return true;
	}
	
	//prints out customer information
	public void customerInfo() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+-----------------------+");
		System.out.println("| Customer Information: |");
		System.out.println("+-----------------------+" + ColorsUtility.ANSI_DEFAULT);
		System.out.println(userList.get(currentUserIndex));
		System.out.println(accList.get(currentUserIndex));
	}
	
	//prints out user's 5 most recent transactions; recent on top & old on bottom
	public void recentTransactions() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+------------------------+");
		System.out.println("| 5 Recent Transactions: |");
		System.out.println("+------------------------+" + ColorsUtility.ANSI_DEFAULT);
		//System.out.println("Most Recent Transactions[Most Recent to Oldest]:");
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
