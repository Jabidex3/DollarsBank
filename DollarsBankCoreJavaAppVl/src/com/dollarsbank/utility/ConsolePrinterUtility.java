package com.dollarsbank.utility;

public class ConsolePrinterUtility {

	public static void initialOutput() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+--------------------------+");
		System.out.println("|DOLLARSBANK Welcomes You!|");
		System.out.println("+--------------------------+" + ColorsUtility.ANSI_DEFAULT);
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println(ColorsUtility.ANSI_GREEN + "Enter Choice (1, 2 or 3) :"+ ColorsUtility.ANSI_DEFAULT);
	}
	
	public static void registrationOutput(int i) {
		if(i==1) {
			System.out.println(ColorsUtility.ANSI_BLUE+ "+--------------------------+");
			System.out.println("|Enter Details For New Account");
			System.out.println("+--------------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("Customer Name: ");
		}
		else if(i==2) {
			System.out.println("Customer Address: ");
		}
		else if(i==3) {
			System.out.println("Customer Contact Number: ");	
		}
		else if(i==4) {
			System.out.println("User ID: ");
		}
		else if(i==5) {
			System.out.println("Password: 8 Characters With Lower, Upper & Special  ");
		}
		else if(i==6) {
			System.out.println("Initial Deposit Amount: ");
		}
	}
	
	public static void loginOutput(int i) {
		if(i==1) {
			System.out.println(ColorsUtility.ANSI_BLUE+ "+--------------------------+");
			System.out.println("|Enter Login Details");
			System.out.println("+--------------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("User Id: ");
		}
		else if(i==2) {
			System.out.println("Password: ");
		}
	}
	
	public static void validUserOutput() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+--------------------------+");
		System.out.println("|WELCOME Customer!!!|");
		System.out.println("+--------------------------+" + ColorsUtility.ANSI_DEFAULT);
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Funds Transfer");
		System.out.println("4. View 5 Recent Transactions");
		System.out.println("5. Display Customer Information");
		System.out.println("6. Sign Out");
		System.out.println();
		System.out.println(ColorsUtility.ANSI_GREEN + "Enter Choice (1, 2, 3, 4, 5 or 6) :"+ ColorsUtility.ANSI_DEFAULT);
	}
	
	public static void depositOutput(int i) {
		if(i==1) {
			System.out.println("Please Enter The Amount You Wish To Deposit:");
		}
		else if(i==2) {
			System.out.print("Deposit Successful! Current Balance is now: $");
		}
	}
	
	public static void withdrawOutput(int i) {
		if(i==1) {
			System.out.println("Please Enter The Amount You Wish To Withdraw:");
		}
		else if(i==2) {
			System.out.print("Withdrawal Successful! Current Balance is now: $");
		}
		else if(i==3) {
			System.out.println("Withdrawal Unsuccessful! Current Balance is less than desired amount!");
		}
	}
	
	public static void errorOutput(int i) {
		if(i==1) {
			
		}
		else if(i==2) {
			
		}
		else if(i==3) {
					
		}
		else if(i==4) {
			
		}
		else if(i==5) {
			
		}
		else if(i==6) {
			
		}
		else if(i==7) {
			
		}
		else if(i==8) {
			
		}
	}

}
