package com.main;

public class User {
	private String userId;
	private String userPin;
	private double accBal;
	private TransHistory transHistory;
	
	public User(String userId,String userPin,double initialBalance) {
		this.userId = userId;
		this.userPin = userPin;
		this.accBal = initialBalance;
		this.transHistory = new TransHistory();
	}
	
	public String getUserId() {
		return userId;
	}
	public double getAccountBalance() {
		return accBal;
	}
	public TransHistory getTransHistory() {
		return transHistory;
	}
	public void deposit(double amount) {
		accBal += amount;
		transHistory.addTransaction(new Transaction("Deposit",amount));
	}
	public boolean withdraw(double amount) {
		if(amount <=accBal) {
			accBal -= amount;
			transHistory.addTransaction(new Transaction("Withdraw",amount));
			return true;
		}
		else
			return false;
	}
	public boolean transfer(User recipient,double amount) {
		if(amount <=accBal) {
			accBal -= amount;
			recipient.deposit(amount);
			transHistory.addTransaction(new Transaction("Transfer to" + recipient.getUserId(),amount));
			recipient.getTransHistory().addTransaction(new Transaction("Transfer from" + this.getUserId(),amount));
			return true;
		}
		else
			return false;
	}

}
