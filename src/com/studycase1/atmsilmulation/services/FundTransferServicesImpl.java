package com.studycase1.atmsilmulation.services;

import java.util.List;
import java.util.Scanner;

import com.studycase1.atmsimulation.model.Account;
import com.studycase1.atmsimulation.view.FundTransferScreen1;
import com.studycase1.atmsimulation.view.FundTransferScreen2;
import com.studycase1.atmsimulation.view.FundTransferScreen3;
import com.studycase1.atmsimulation.view.FundTransferScreen4;
import com.studycase1.atmsimulation.view.FundTransferSummaryScreen;
import com.studycase1.atmsimulation.view.TransactionScreen;
import com.studycase1.atmsimulation.view.WelcomeScreen;

public class FundTransferServicesImpl implements FundTransferServices {

	@Override
	public void inputDestinationAccount() {
		
		List<Account> users = Account.getInstance();
		String regex = "[0-9]+";
		FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
		FundTransferScreen1 transferScreen1 = new FundTransferScreen1();
		Scanner scan = new Scanner(System.in);
		FundTransferScreen1.destinationAcc = scan.nextLine();

		if (!FundTransferScreen1.destinationAcc.matches(regex)) {
			System.out.println("Invalid account");
			transferScreen1.show();
		}

		if (isExists(users)) {
			transferScreen2.show();
		} else {
			System.out.println("Invalid account");
			transferScreen1.show();
		}
	}

	@Override
	public void inputAmountScreen() {
		
		String regex = "\\d+";
		Scanner scan = new Scanner(System.in);
		FundTransferScreen3 transferScreen3 = new FundTransferScreen3();
		FundTransferScreen2 transferScreen2 = new FundTransferScreen2();
		FundTransferScreen1.tranferAmt = scan.nextLine();

		if (!FundTransferScreen1.tranferAmt.matches(regex)) {
			System.out.println("Invalid ammount");
			transferScreen2.show();
		} else if (Integer.parseInt(FundTransferScreen1.tranferAmt) > 1000) {
			System.out.println("Maximum amount to transfer is $1000");
			transferScreen2.show();
		} else if (WelcomeScreen.balance - Integer.parseInt(FundTransferScreen1.tranferAmt) < 0) {
			System.out.println("Insufficient balance $" + FundTransferScreen1.tranferAmt);
			transferScreen2.show();
		} else if (Integer.parseInt(FundTransferScreen1.tranferAmt) < 1) {
			System.out.println("Minimum amount to transfer is $1");
		} else {
			transferScreen3.show();
		}
	}

	@Override
		
	public void inputReferenceNumberScreen() {
		
		FundTransferScreen4 fundTransferScreen4 = new FundTransferScreen4();
		FundTransferScreen3 fundTransferScreen3 = new FundTransferScreen3();
		String regex = "[0-9]+";
		Scanner scan = new Scanner(System.in);
		FundTransferScreen1.referenceNum = scan.nextLine();

		if (!FundTransferScreen1.referenceNum.matches(regex) && !FundTransferScreen1.referenceNum.isEmpty()) {
			System.out.println("Invalid Reference Number");
			fundTransferScreen3.show();
		} else {
			
			fundTransferScreen4.show();
		}

	}

	@Override
	public void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, List<Account> users) {

		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {
		case "1":
			FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
			WelcomeScreen.balance -= Integer.parseInt(FundTransferScreen1.tranferAmt);
			addAmountToDestination(users);
			fundTransferSummaryScreen.show();
			break;
		case "2":
			TransactionScreen transactionScreen = new TransactionScreen();
			transactionScreen.show();
			break;
		case "":
			fundTransferScreen.show();
			break;
		default:
			break;
		}
	}

	@Override
	public void transaction(TransactionScreen transactionScreen) {
		List<Account> users = Account.getInstance();

		for (int i = 0; i < users.size(); i++) {
			if (WelcomeScreen.accNumberStatic.equals(users.get(i).getAccountNumber())
					&& WelcomeScreen.pinStatic.equals(users.get(i).getPIN())) {
				users.get(i).setBalance(WelcomeScreen.balance);
			}
		}
		System.out.println("Transaction Succeed");
		transactionScreen.show();
		
	}

	@Override
	public boolean isExists(List<Account> users) {
		boolean isExists = false;
		for (int i = 0; i < users.size(); i++) {
			if (FundTransferScreen1.destinationAcc.equals(users.get(i).getAccountNumber())) {
				isExists = true;
				break;
			} else {
				isExists = false;
			}
		}
		return isExists;
	}

	@Override
	public void addAmountToDestination(List<Account> users) {
		for (int i = 0; i < users.size(); i++) {
			if (FundTransferScreen1.destinationAcc.equals(users.get(i).getAccountNumber())){
				int temp = users.get(i).getBalance() + Integer.parseInt(FundTransferScreen1.tranferAmt);
				users.get(i).setBalance(temp);
				break;
			}
		}
	}

}
