package com.studycase1.atmsimulation.view;

import java.util.Scanner;

public class TransactionScreen {

	public void show() {

		WithdrawScreen withdrawScreen = new WithdrawScreen();
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		FundTransferScreen1 fundTransferScreen = new FundTransferScreen1();
		
		System.out.println();
		System.out.println("Transaction Screen");
		System.out.println("----------------");

		System.out.println("1. Withdraw ");
		System.out.println("2. Fund Transfer");
		System.out.println("3. Exit ");

		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {

		case "1":
			withdrawScreen.show();
			break;
		case "2":
			fundTransferScreen.show();
			break;
		case "3":
			welcomeScreen.show();
			break;
		case "":
			welcomeScreen.show();
			break;
		default:
			show();
			break;
		}

	}

}
