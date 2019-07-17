package com.studycase1.atmsilmulation.view;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SummaryScreen {

	public void show() {
		
		TransactionScreen ts = new TransactionScreen();
		WelcomeScreen ws = new WelcomeScreen();
		
		Calendar cal = Calendar.getInstance();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("Summary Screen");
		System.out.println("----------------");
		System.out.println("Date : " + dtf.format(now));
		System.out.println("Withdraw: " + WithdrawScreen.withdrawAmount);
		System.out.println("Balance: $" + WelcomeScreen.balance);
		
		System.out.println("1. Transaction");
		System.out.println("2. Exit");
		
		int opt = scan.nextInt();
		switch (opt) {
		case 1:
			ts.show();
			break;
		case 2:
			ws.show();
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}
