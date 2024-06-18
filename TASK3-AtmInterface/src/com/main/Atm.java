package com.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
	private User currentUser;
	
	public boolean login(String userId,String userPin) {
		//you can replace this with your logic
		//hard coded values
		if (userId.equals("SBI_ATM") && userPin.equals("7243")) {
			currentUser = new User(userId,userPin,50000.0);
			return true;
		}
		else
			return false;
	}
	public void displayOptions() {
		System.out.println("Choose an options -->");
		System.out.println("1 --> Withdraw");
		System.out.println("2 --> Deposit");
		System.out.println("3 --> Transfer");
		System.out.println("4 --> Transaction History");
		System.out.println("5 --> Exit");
	}
	public void performOption(int option) {
		Scanner sc = new Scanner(System.in);
		
		switch(option) {
		case 1:
			System.out.println("Enter the amount to withdraw :");
			double withdrawAmount = sc.nextDouble();
			boolean successWithdraw = currentUser.withdraw(withdrawAmount);
			if(successWithdraw) {
				System.out.println("Withdrawal successful. Current balance :" + currentUser.getAccountBalance());
				
			}
			else {
				System.out.println("Insufficient funds.Current balance :" + currentUser.getAccountBalance());
			}
			break;
			
		case 2:
			System.out.println("Enter the amount to deposit :");
			double depositAmount = sc.nextDouble();
			currentUser.deposit(depositAmount);
			System.out.println("Deposit successful . Current balance : " + currentUser.getAccountBalance());
			break;
			
		case 3:
			System.out.println("Enter the recipient's user ID : ");
			String recipientId = sc.next();
			System.out.println("Enter the amount to transfer :");
			double transferAmount =sc.nextDouble();
			User recipient = getUserById(recipientId);
			if(recipient !=null) {
				boolean successTransfer = currentUser.transfer(recipient, transferAmount);
				if(successTransfer) {
					System.out.println("Transfer successful . Current balance :" + currentUser.getAccountBalance());
				}
				else {
					System.out.println("Insufficient funds . Current balance :" + currentUser.getAccountBalance());
				}
				
			}
			else {
				System.out.println("Recipient not found!!");
			}
			break;
		case 4:
			displayTransHistory();
			break;
		case 5:
			System.out.println("Thank you for using ATM. See you later..........");
			break;
		default:
			System.out.println("Invalid option.Please try again!!!");
			
		}
		
		
		//sc.close();
	}
	
	private void displayTransHistory() {
		ArrayList<Transaction> transactions = currentUser.getTransHistory().getTransactions();
		System.out.println("\nTransaction History :");
		for(Transaction transaction : transactions) {
			System.out.println(transaction.getType() + " - Amount: " + transaction.getAmount() + " - timestamp:" + transaction.getTimestamp());
			
		}
	}
	private User getUserById(String userId) {
		//replace this with your user retrieval logic
		//we use hard coded user
		if(userId.equals("SBI_ATM")) {
			return new User("SBI_ATM","7243", 1000.0);
		}

		return null;
		
	}

}
