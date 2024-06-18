package com.main;

import java.util.ArrayList;

public class TransHistory {
	private ArrayList<Transaction> transactions;
	
	public TransHistory() {
		this.transactions = new ArrayList<Transaction>();
	}
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	public ArrayList<Transaction> getTransactions(){
		return transactions;
		
	}

}
