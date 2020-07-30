package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DollarsBankController dbc = new DollarsBankController();
		boolean runApp = true;
		while(runApp) {
			ConsolePrinterUtility.initialOutput();
			try {
				int choice = Integer.parseInt(scan.nextLine());
				if(choice==1) {
					System.out.println();
					//System.out.println("selected 1");
					ConsolePrinterUtility.registrationOutput(1);
					String cust_name = scan.nextLine();
					ConsolePrinterUtility.registrationOutput(2);
					String cust_address = scan.nextLine();
					ConsolePrinterUtility.registrationOutput(3);
					String phone_num = scan.nextLine();
					ConsolePrinterUtility.registrationOutput(4);
					String uid = scan.nextLine();
					ConsolePrinterUtility.registrationOutput(5);
					String pw;
					while(true) {
						pw = scan.nextLine();
						if(pw.length()<8) {
							System.out.println("Password must be atleast 8 characters long! Please enter a new one: ");
						}
						else {
							break;
						}
					}
					ConsolePrinterUtility.registrationOutput(6);
					double initial_balance = Double.parseDouble(scan.nextLine());
					
					dbc.addCustomer(new Customer(cust_name,cust_address,phone_num,uid));
					dbc.addAcc(new Account(uid,pw,initial_balance));
					
				}
				else if(choice==2) {
					System.out.println();
					//System.out.println("selected 2");
					boolean loggedIn = false;
					while(true) {
						ConsolePrinterUtility.loginOutput(1);
						String entered_id = scan.nextLine();
						ConsolePrinterUtility.loginOutput(2);
						String entered_pw = scan.nextLine();
						if(dbc.checkCredentials(entered_id,entered_pw)) {
							loggedIn = true;
							break;
						}
						else {
							System.out.println("Invalid Credentials! Try Again!");
						}
					}
					while(loggedIn) {
						ConsolePrinterUtility.validUserOutput();
						try {
							int loggedInUserChoice = Integer.parseInt(scan.nextLine());
							if(loggedInUserChoice==1) {//deposit
								//System.out.println("selected 1");
								
								while(true) {
									ConsolePrinterUtility.depositOutput(1);
									try {
										double amountDepo = Double.parseDouble(scan.nextLine());
										if(amountDepo>0) {
											if(dbc.deposit(amountDepo)) {
												ConsolePrinterUtility.depositOutput(2);
												System.out.println(dbc.currBalance());
												break;
											}
										}
										else {
											System.out.println("Invalid Deposit Amount!");
										}
									}
									catch(Exception e) {
										System.out.println("Invalid Deposit Amount!");
									}
								}
							}
							else if(loggedInUserChoice==2) {//withdraw
								//System.out.println("selected 2");
								while(true) {
									ConsolePrinterUtility.withdrawOutput(1);
									try {
										double amountWithdraw = Double.parseDouble(scan.nextLine());
										if(amountWithdraw>0) {
											if(dbc.withdraw(amountWithdraw)) {
												ConsolePrinterUtility.withdrawOutput(2);
												System.out.println(dbc.currBalance());
												break;
											}
											else {
												ConsolePrinterUtility.withdrawOutput(3);
												System.out.println("Current Balance is $"+ dbc.currBalance());
											}
										}
										else {
											System.out.println("Invalid Withdrawal Amount!");
										}
									}
									catch(Exception e) {
										System.out.println("Invalid Deposit Amount!");
									}
								}
							}
							else if(loggedInUserChoice==3) { //transfer funds to other account or savings
								System.out.println("selected 3");			
							}
							else if(loggedInUserChoice==4) { //5 recent transactions
								//System.out.println("selected 4");
								dbc.recentTransactions();
							}
							else if(loggedInUserChoice==5) { //display customer info
								//System.out.println("selected 5");
								dbc.customerInfo();
							}
							else if(loggedInUserChoice==6) {
								System.out.println("You have signed out!");
								loggedIn = false;
							}
							
							
						}
						catch(Exception e) {
							System.out.println("invalid input. something went wrong");
						}
					}
					
					
					
				}
				else if(choice ==3) {
					runApp = false;
					System.out.println("Thank you for using the DOLLARSBANK Application! Goodbye!");
				}
				else if(choice ==4) {
					dbc.getUserListInfo();
				}
				else if(choice ==5) {
					dbc.getAccListInfo();
				}
				else {
					System.out.println("Invalid Input. Try Again");
				}
			}
			catch(Exception e){
				System.out.println("Invalid Input. Try Again");
			}
	}

}
}
