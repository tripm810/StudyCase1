package com.studycase1.atmsimulation;

import java.util.Scanner;

import com.studycase1.services.FundTransferServices;
import com.studycase1.services.FundTransferServicesImpl;

public class FundTransferSummaryScreen {

	public void show() {
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		FundTransferServices fundTransferServices = new FundTransferServicesImpl();
		FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
		System.out.println("Fund Transfer Summary Screen");
		System.out.println("----------------------");
		
		System.out.println("Destination Account: " + FundTransferScreen.destinationAcc);
		System.out.println("Transfer Amount: $" + FundTransferScreen.tranferAmt);
		System.out.println("Reference Number: " + FundTransferScreen.referenceNum);
		System.out.println("Balance: $" + WelcomeScreen.balance);
		
		System.out.println("1. Transaction");
		System.out.println("2. Exit");
		
		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {
		case "1":
			fundTransferServices.transaction(fundTransferSummaryScreen);
			break;
		case "2":
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
