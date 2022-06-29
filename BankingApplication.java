package com.ATMApplication;

import java.util.Scanner;

class Bankaccount {

	int balance;
	int previousTransaction;
	String customerName;
	String customerId;

	public Bankaccount(String cusName, String cusId) {

		customerName = cusName;
		customerId = cusId;
	}

	void deposite(int amount) {

		if (amount > 0) {

			balance = balance + amount;
			previousTransaction = amount;
		} else {
			System.out.println("Please enter valid amount");
		}
	}

	void withdraw(int amount) {
		if (amount <= 0) {
			System.out.println("Please enter valid amount");
		}

		if (balance >= amount) {

			balance = balance - amount;
			previousTransaction = -amount;
		} else {
			System.out.println("Insufficient Fund!");
		}
	}

	void getPrevioustransaction() {

		if (previousTransaction > 0) {
			System.out.println("deposited: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No Transaction occured");
		}

	}

	void showMenu() {

		char option = '\0';

		Scanner scn = new Scanner(System.in);

		System.out.println("welcome " + customerName);
		System.out.println("your ID :->" + customerId);
		System.out.println("\n");
		System.out.println("A. check Balance");
		System.out.println("B. Deposite");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Tranction");
		System.out.println("E. Exit");

		do {
			System.out.println("------>Enter Option<--------");
			System.out.println("=================");
			option = scn.next().charAt(0);
			System.out.println("\n");
			switch (option) {
			case 'A':
				System.out.println("=================");
				System.out.println("balance=" + balance);
				System.out.println("=================");
				System.out.println("\n");
				break;

			case 'B':
				System.out.println("=================");
				System.out.println("Enter Deposite Amout");
				System.out.println("=================");
				int amount = scn.nextInt();
				deposite(amount);
				System.out.println("\n");

				break;

			case 'C':
				System.out.println("Enter Withdraw Amout");
				System.out.println("=================");
				int amount2 = scn.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
			case 'D':
				System.out.println("=================");
				getPrevioustransaction();
				System.out.println("\n");

				break;
			case 'E':
				System.out.println("#####BYE@BYE######");

				System.out.println("\n");

				break;

			default:
				System.out.println("Invalid option! Please Enter Again");

			}

		} while (option != 'E');
		System.out.println("Thanku for using our services");

	}
}

public class BankingApplication {

	public static void main(String[] args) {

		Bankaccount obj1 = new Bankaccount("faraz", "Ba707");
		obj1.showMenu();
	}
}
