package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

/***
 * Java Bank Application
 * @author Jabid Methun
 *
 */
public class DollarsBankApplication {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DollarsBankController dbc = new DollarsBankController();
		boolean runApp = true;
		while(runApp) {
			ConsolePrinterUtility.initialOutput();
			try {
				int choice = Integer.parseInt(scan.nextLine());
				//Initial User Interface
				if(choice==1) {// Create New Account
					ConsolePrinterUtility.registrationOutput(1);
					System.out.print(ColorsUtility.ANSI_CYAN);
					String cust_name = scan.nextLine();
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					ConsolePrinterUtility.registrationOutput(2);
					System.out.print(ColorsUtility.ANSI_CYAN);
					String cust_address = scan.nextLine();
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					String phone_num="";
					while(true) {
						ConsolePrinterUtility.registrationOutput(3); //contact #
						System.out.print(ColorsUtility.ANSI_CYAN);
						phone_num = scan.nextLine();
						if(dbc.validnum(phone_num)) {
							break;
						}
						else {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							ConsolePrinterUtility.errorOutput(6);
						}
					}
					
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					
					String uid ="";
					while(true) {
						ConsolePrinterUtility.registrationOutput(4); //user id [unique]
						System.out.print(ColorsUtility.ANSI_CYAN);
						uid=scan.nextLine();
						if(!dbc.checkUserId(uid)) {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							ConsolePrinterUtility.errorOutput(5);
						}
						else {
							break;
						}
					}
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					
					String pw;
					while(true) {
						ConsolePrinterUtility.registrationOutput(5);
						System.out.print(ColorsUtility.ANSI_CYAN);
						pw = scan.nextLine();
						if(!dbc.checkPassValidity(pw)) {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							ConsolePrinterUtility.errorOutput(2);
						}
						else {
							break;
						}
					}
					
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					
					double initial_balance;
					while(true) {
						ConsolePrinterUtility.registrationOutput(6);
						System.out.print(ColorsUtility.ANSI_CYAN);
						try {
							initial_balance = Double.parseDouble(scan.nextLine());
							if(initial_balance>0) {
								break;
							}
							else if(initial_balance<=0) {
								System.out.print(ColorsUtility.ANSI_DEFAULT);
								ConsolePrinterUtility.errorOutput(3);
							}
							else {
								System.out.print(ColorsUtility.ANSI_DEFAULT);
								ConsolePrinterUtility.errorOutput(1);
							}
						}
						catch(Exception e) {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							ConsolePrinterUtility.errorOutput(1);
						}
					}
					
					System.out.print(ColorsUtility.ANSI_DEFAULT);
					dbc.addCustomer(new Customer(cust_name,cust_address,phone_num,uid));
					dbc.addAcc(new Account(uid,pw,initial_balance));
					
				}
				else if(choice==2) {
					//Log In
					boolean loggedIn = false;
					while(true) {
						ConsolePrinterUtility.loginOutput(1);
						System.out.print(ColorsUtility.ANSI_CYAN);
						String entered_id = scan.nextLine();
						System.out.print(ColorsUtility.ANSI_DEFAULT);
						ConsolePrinterUtility.loginOutput(2);
						System.out.print(ColorsUtility.ANSI_CYAN);
						String entered_pw = scan.nextLine();
						if(dbc.checkCredentials(entered_id,entered_pw)) {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							loggedIn = true;
							break;
						}
						else {
							System.out.print(ColorsUtility.ANSI_DEFAULT);
							ConsolePrinterUtility.errorOutput(4);
						}
					}
					
					
					while(loggedIn) {
						//Print Logged In User Interface
						ConsolePrinterUtility.validUserOutput();
						try {
							int loggedInUserChoice = Integer.parseInt(scan.nextLine());
							if(loggedInUserChoice==1) {//deposit								
								while(true) {
									ConsolePrinterUtility.depositOutput(1);
									try {
										System.out.print(ColorsUtility.ANSI_CYAN);
										double amountDepo = Double.parseDouble(scan.nextLine());
										if(amountDepo>0) {
											if(dbc.deposit(amountDepo)) {
												System.out.print(ColorsUtility.ANSI_DEFAULT);
												ConsolePrinterUtility.depositOutput(2);
												System.out.println(dbc.currBalance());
												break;
											}
										}
										else {
											System.out.print(ColorsUtility.ANSI_DEFAULT);
											ConsolePrinterUtility.depositOutput(3);
										}
									}
									catch(Exception e) {
										System.out.print(ColorsUtility.ANSI_DEFAULT);
										ConsolePrinterUtility.depositOutput(4);
									}
								}
							}
							else if(loggedInUserChoice==2) {//withdraw
								while(true) {
									ConsolePrinterUtility.withdrawOutput(1);
									try {
										System.out.print(ColorsUtility.ANSI_CYAN);
										double amountWithdraw = Double.parseDouble(scan.nextLine());
										if(amountWithdraw>0) {
											if(dbc.withdraw(amountWithdraw)) {
												System.out.print(ColorsUtility.ANSI_DEFAULT);
												ConsolePrinterUtility.withdrawOutput(2);//success
												System.out.println(dbc.currBalance());
												break;
											}
											else {//unsuccessful
												System.out.print(ColorsUtility.ANSI_DEFAULT);
												ConsolePrinterUtility.withdrawOutput(3);
												System.out.println("Current Balance is $"+ dbc.currBalance());
											}
										}
										else {
											System.out.print(ColorsUtility.ANSI_DEFAULT);
											ConsolePrinterUtility.withdrawOutput(5);
										}
									}
									catch(Exception e) {
										System.out.print(ColorsUtility.ANSI_DEFAULT);
										ConsolePrinterUtility.withdrawOutput(4);
									}
								}
							}
							else if(loggedInUserChoice==3) { //transfer funds to other accounts via user id
								while(true) {
									ConsolePrinterUtility.transferOutput(1);
									System.out.print(ColorsUtility.ANSI_CYAN);
									String tid=scan.nextLine();
									System.out.print(ColorsUtility.ANSI_DEFAULT);
									if(!dbc.transferCheckId(tid)) {
										ConsolePrinterUtility.transferOutput(3);
									}
									else {
										while(true) {
											ConsolePrinterUtility.transferOutput(2);
											try {
												System.out.print(ColorsUtility.ANSI_CYAN);
												double amountTransfer = Double.parseDouble(scan.nextLine());
												if(amountTransfer>0) {
													if(dbc.transferCheck(amountTransfer)) {//valid amt
														System.out.print(ColorsUtility.ANSI_DEFAULT);
														//do transfer of money
														dbc.transfer(tid,amountTransfer);
														ConsolePrinterUtility.transferOutput(4);//valid
														System.out.println(dbc.currBalance());
														break;
													}
													else {//invalid amt
														System.out.print(ColorsUtility.ANSI_DEFAULT);
														ConsolePrinterUtility.transferOutput(7);
														System.out.println("Current Balance is $"+ dbc.currBalance());
													}
												}
												else {
													System.out.print(ColorsUtility.ANSI_DEFAULT);
													ConsolePrinterUtility.transferOutput(6);
												}
											}
											catch(Exception e) {
												System.out.print(ColorsUtility.ANSI_DEFAULT);
												ConsolePrinterUtility.transferOutput(5);
											}
										}
										break;
									}
									
								}
							}
							else if(loggedInUserChoice==4) { //5 recent transactions
								dbc.recentTransactions();
							}
							else if(loggedInUserChoice==5) { //display customer info
								dbc.customerInfo();
							}
							else if(loggedInUserChoice==6) {//sign out
								System.out.println("You have signed out!");
								loggedIn = false;
							}
							else {
								ConsolePrinterUtility.errorOutput(1);
							}
						}
						catch(Exception e) {
							ConsolePrinterUtility.errorOutput(1);
						}
					}
				}
				else if(choice ==3) {
					//Exit
					runApp = false;
					System.out.println("Thank you for using the DOLLARSBANK Application! Goodbye!");
				}
//				else if(choice ==4) {
//					//Lists All Users of the Bank
//					dbc.getUserListInfo();
//				}
//				else if(choice ==5) {
//					//Lists User Acc Info
//					dbc.getAccListInfo();
//				}
				else {
					ConsolePrinterUtility.errorOutput(1);
				}
			}
			catch(Exception e){
				ConsolePrinterUtility.errorOutput(1);
			}
	}

}
}
