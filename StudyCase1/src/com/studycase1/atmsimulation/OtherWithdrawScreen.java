package com.studycase1.atmsimulation;

import java.util.List;
import com.studycase1.model.*;
import com.studycase1.services.WithdrawServices;
import com.studycase1.services.WithdrawServicesImpl;

import java.util.Scanner;

public class OtherWithdrawScreen {

	public void show() {
		List<Account> users = Account.getInstance();
		SummaryScreen summaryScreen = new SummaryScreen();
		OtherWithdrawScreen otherWithdrawScreen = new OtherWithdrawScreen();
		WithdrawServices withdrawServices = new WithdrawServicesImpl();

		System.out.println("Other Withdraw Screen");
		System.out.println("--------------------");
		System.out.print("Enter amount to withdraw: ");
		Scanner scan = new Scanner(System.in);
		String amount = scan.nextLine();

		withdrawServices.validateAndCalculateWithdrawAmount(amount, users, otherWithdrawScreen, summaryScreen);
	}
}