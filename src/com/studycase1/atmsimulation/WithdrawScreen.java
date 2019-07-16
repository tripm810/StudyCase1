package com.studycase1.atmsimulation;

import java.util.List;
import java.util.Scanner;

import com.studycase1.model.Account;
import com.studycase1.services.WithdrawServices;
import com.studycase1.services.WithdrawServicesImpl;

public class WithdrawScreen {
	public static String withdrawAmount;

	public void show() {

		System.out.println("1. $10");
		System.out.println("2. $50");
		System.out.println("3. $100");
		System.out.println("4. Other");
		System.out.println("5. Back");

		Scanner scan = new Scanner(System.in);
		int opt = scan.nextInt();
		List<Account> users = Account.getInstance();
		SummaryScreen summaryScreen = new SummaryScreen();
		TransactionScreen transactionScreen = new TransactionScreen();
		OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
		WithdrawServices withdrawServices = new WithdrawServicesImpl();
		
		switch (opt) {
		case 1:
			withdrawServices.caculateWithdrawAmount(users, WelcomeScreen.accNumberStatic, WelcomeScreen.pinStatic, summaryScreen, transactionScreen, 10);
			break;
		case 2:
			withdrawServices.caculateWithdrawAmount(users, WelcomeScreen.accNumberStatic, WelcomeScreen.pinStatic, summaryScreen, transactionScreen, 50);
			break;
		case 3:
			withdrawServices.caculateWithdrawAmount(users, WelcomeScreen.accNumberStatic, WelcomeScreen.pinStatic, summaryScreen, transactionScreen, 100);
			break;
		case 4:
			otherWithdrawScreen.show();
			break;
		case 5:
			transactionScreen.show();
			break;
		default:
			transactionScreen.show();
			break;
		}
	}
}
