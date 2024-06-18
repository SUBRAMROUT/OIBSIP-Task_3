package com.main;

import java.util.Scanner;

public class AtmInterface {

	public static void main(String[] args) {
		Atm atm = new Atm();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your user ID...");
		String userId =sc.next();
		System.out.println("Enter your user PIN...");
		String userPin =sc.next();
		
		boolean loggedIn =atm.login(userId, userPin);
		
		if(loggedIn) {
			System.out.println("Login successful . Welcome," + userId );
			int option;
			while(true) {
				atm.displayOptions();
				System.out.println("Enter option : ");
				option = sc.nextInt();
				
				if(option == 0) {
					break;
				}
				atm.performOption(option);
			}
			
		}
		else {
			System.out.println("Login failed. Invalid user ID or PIN");
		}
		sc.close();
	}

}
