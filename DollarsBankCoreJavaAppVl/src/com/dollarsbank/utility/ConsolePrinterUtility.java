package com.dollarsbank.utility;

public class ConsolePrinterUtility {

	//initial user interface
	public static void initialOutput() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+---------------------------+");
		System.out.println("| DOLLARSBANK Welcomes You! |");
		System.out.println("+---------------------------+" + ColorsUtility.ANSI_DEFAULT);
		System.out.println("1. Create New Account");
		System.out.println("2. Login");
		System.out.println("3. Exit");
		System.out.println();
		System.out.println(ColorsUtility.ANSI_GREEN + "Enter Choice (1, 2 or 3) :"+ ColorsUtility.ANSI_DEFAULT);
	}
	
	public static void registrationOutput(int i) {
		if(i==1) {
			System.out.println(ColorsUtility.ANSI_BLUE+ "+-------------------------------+");
			System.out.println("| Enter Details For New Account |");
			System.out.println("+-------------------------------+" + ColorsUtility.ANSI_DEFAULT);
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
			System.out.println(ColorsUtility.ANSI_BLUE+ "+---------------------+");
			System.out.println("| Enter Login Details |");
			System.out.println("+---------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("User Id: ");
		}
		else if(i==2) {
			System.out.println("Password: ");
		}
	}
	
	public static void validUserOutput() {
		System.out.println(ColorsUtility.ANSI_BLUE+ "+---------------------+");
		System.out.println("| WELCOME Customer!!! |");
		System.out.println("+---------------------+" + ColorsUtility.ANSI_DEFAULT);
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
			System.out.println(ColorsUtility.ANSI_BLUE+ "+------------------+");
			System.out.println("| Deposit Details: |");
			System.out.println("+------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("Please Enter The Amount You Wish To Deposit:");
		}
		else if(i==2) {
			System.out.print("Deposit Successful! Current Balance is now: $");
		}
		else if(i==3) {
			System.out.println(ColorsUtility.ANSI_RED+"Deposit Unsuccessful! Cannot enter an amount that is less than or equal to zero!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==4) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid Deposit Amount!"+ ColorsUtility.ANSI_DEFAULT);
		}
	}
	
	public static void withdrawOutput(int i) {
		if(i==1) {
			System.out.println(ColorsUtility.ANSI_BLUE+ "+---------------------+");
			System.out.println("| Withdrawal Details: |");
			System.out.println("+---------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("Please Enter The Amount You Wish To Withdraw:");
		}
		else if(i==2) {
			System.out.print("Withdrawal Successful! Current Balance is now: $");
		}
		else if(i==3) {
			System.out.println(ColorsUtility.ANSI_RED+"Withdrawal Unsuccessful! Current Balance is less than desired amount!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==4) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid Withdrawal Amount!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i ==5) {
			System.out.println(ColorsUtility.ANSI_RED+"Withdrawal Unsuccessful! Cannot withdraw an amount that is less than or equal to zero!"+ ColorsUtility.ANSI_DEFAULT);
		}
	}
	
	public static void transferOutput(int i) {
		if(i==1) {
			System.out.println(ColorsUtility.ANSI_BLUE+ "+-------------------------+");
			System.out.println("| Funds Transfer Details: |");
			System.out.println("+-------------------------+" + ColorsUtility.ANSI_DEFAULT);
			System.out.println("Please Enter The User Id of the person you wish to send money to:");
		}
		else if(i==2) {
			System.out.println("Please enter the amount of money you wish to send:");
		}
		else if(i==3) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid User Id entered! "+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==4) {
			System.out.print("Money Transfer Successful! Current Balance is now: $");		
		}
		else if(i==5) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid Transfer Amount!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==6) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid Transfer Amount! Cannot transfer an amount that is less than or equal to zero!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==7) {
			System.out.println(ColorsUtility.ANSI_RED+"Invalid Transfer Amount! Current Balance is less than desired amount!"+ ColorsUtility.ANSI_DEFAULT);
		}
	}
	
	public static void errorOutput(int i) {
		System.out.print(ColorsUtility.ANSI_RED);
		if(i==1) {
			System.out.println("Invalid Input. Try Again!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==2) {
			System.out.println("Password must be atleast 8 characters long, possess an upper case character, possess a lower case character and possess a special character! Please enter a new one: "+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==3) {
			System.out.println("You have entered an initial deposit amount which is either 0 or less than zero. Please enter a positive value."+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==4) {
			System.out.println("Invalid Credentials! Try Again!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==5) {
			System.out.println("User Id Unavailable. Please Enter A New One!"+ ColorsUtility.ANSI_DEFAULT);
		}
		else if(i==6) {
			System.out.println("Phone numbers must possess 10 digits!"+ ColorsUtility.ANSI_DEFAULT);
		}
	}

}
