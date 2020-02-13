/*
 * LocalBank2.java from Chapter 12
 * Simulates a bank and its cusomters. Accounts 
 * information is read from and written to a file.
 * Lawrenceville Press
 * June 10, 2005
 */
 
 /**
  * A bank where accounts can be opened or closed and customers can 
  * make transactions.
  */
 
 import java.io.*;
 import java.util.Scanner;
  
 public class LocalBank {

	public static void main(String[] args) {
		File accountsFile = new File("LBAccounts.dat");
		Bank easySave = new Bank(accountsFile);
		Scanner input = new Scanner(System.in);
		String action, acctID;
		Double amt;
				
		/* display menu of choices */
		do {
			System.out.println("\nDeposit\\Withdrawal\\Check balance");
			System.out.println("Add an account\\Remove an account");
			System.out.println("Quit\n");
			System.out.print("Enter choice: ");
			action = input.next();
			
			if (action.equalsIgnoreCase("A")) {
				easySave.addAccount();
			} else if (!action.equalsIgnoreCase("Q")) {
				System.out.print("Enter account ID: ");
				acctID = input.next();
				if (action.equalsIgnoreCase("D")) {
					System.out.print("Enter deposit amount: ");
					amt = input.nextDouble();
					easySave.transaction(1, acctID, amt);
				} else if (action.equalsIgnoreCase("W")) {
					System.out.print("Enter withdrawal amount: ");
					amt = input.nextDouble();
					easySave.transaction(2, acctID, amt);
				} else if (action.equalsIgnoreCase("C")) {
					easySave.checkBalance(acctID);
				} else if (action.equalsIgnoreCase("R")) {
					easySave.deleteAccount(acctID);
				}
			}
		} while (!action.equalsIgnoreCase("Q"));
		
		easySave.updateAccounts(accountsFile);		//write accounts to file
	}
}