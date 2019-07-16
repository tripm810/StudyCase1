package com.studycase1.services;

import java.util.List;
import java.util.Scanner;

import com.studycase1.atmsimulation.FundTransferScreen;
import com.studycase1.atmsimulation.FundTransferSummaryScreen;
import com.studycase1.atmsimulation.TransactionScreen;
import com.studycase1.atmsimulation.WelcomeScreen;
import com.studycase1.model.Account;

public class FundTransferServicesImpl implements FundTransferServices {

	@Override
	public void inputDestinationAccount() {
		String regex = "[0-9]+";
		List<Account> users = Account.getInstance();
		int temp = 0;

		TransactionScreen ts = new TransactionScreen();
		System.out.print("Please enter destination account: ");
		Scanner scan = new Scanner(System.in);
		FundTransferScreen.destinationAcc = scan.nextLine();

		if (!FundTransferScreen.destinationAcc.matches(regex)) {
			System.out.println("Invalid account");
			inputDestinationAccount();
		}

		for (int i = 0; i < users.size(); i++) {
			if (FundTransferScreen.destinationAcc.equals(users.get(i).getAccountNumber())) {
				temp = 2;
				break;
			} else {
				temp = 1;
			}
		}
		if (temp == 2) {
			inputAmount();
		} else if (temp == 1) {
			System.out.println("Invalid account");
			inputDestinationAccount();
		}
	}

	@Override
	public void inputAmount() {

		String regex = "\\d+";
		System.out.print("Please enter transfer amount: ");
		Scanner scan = new Scanner(System.in);
		FundTransferScreen.tranferAmt = scan.nextLine();

		if (!FundTransferScreen.tranferAmt.matches(regex)) {
			System.out.println("Invalid ammount");
			inputAmount();
		} else if (Integer.parseInt(FundTransferScreen.tranferAmt) > 1000) {
			System.out.println("Maximum amount to transfer is $1000");
			inputAmount();
		} else if (WelcomeScreen.balance - Integer.parseInt(FundTransferScreen.tranferAmt) < 0) {
			System.out.println("Insufficient balance $" + FundTransferScreen.tranferAmt);
			inputAmount();
		} else if (Integer.parseInt(FundTransferScreen.tranferAmt) < 1) {
			System.out.println("Minimum amount to transfer is $1");
		} else {
			inputReferenceNumber();
		}
	}

	@Override
	public void inputReferenceNumber() {
		FundTransferScreen fundTransferScreen = new FundTransferScreen();
		String regex = "[0-9]+";
		System.out.print("Please enter reference number: ");
		Scanner scan = new Scanner(System.in);
		FundTransferScreen.referenceNum = scan.nextLine();

		if (!FundTransferScreen.referenceNum.matches(regex) && !FundTransferScreen.referenceNum.isEmpty()) {
			System.out.println("Invalid Reference Number");
			inputReferenceNumber();
		} else {
			transferConfirm(fundTransferScreen);
		}

	}

	@Override
	public void transferConfirm(FundTransferScreen fundTransferScreen) {

		System.out.println("Transfer Confirmation");
		System.out.println("Destination Account: " + FundTransferScreen.destinationAcc);
		System.out.println("Transfer Amount: $" + FundTransferScreen.tranferAmt);
		System.out.println("Reference Number: " + FundTransferScreen.referenceNum);

		System.out.println("1. Confirm Trx");
		System.out.println("2. Cancel Trx");

		Scanner scan = new Scanner(System.in);
		String opt = scan.nextLine();

		switch (opt) {
		case "1":
			FundTransferSummaryScreen fundTransferSummaryScreen = new FundTransferSummaryScreen();
			System.out.println("Move to fund Transfer summary screen");
			WelcomeScreen.balance -= Integer.parseInt(FundTransferScreen.tranferAmt);
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
	public void transaction(FundTransferSummaryScreen fundTransferSummaryScreen) {
		List<Account> users = Account.getInstance();

		for (int i = 0; i < users.size(); i++) {
			if (WelcomeScreen.accNumberStatic.equals(users.get(i).getAccountNumber())
					&& WelcomeScreen.pinStatic.equals(users.get(i).getPIN())) {
				users.get(i).setBalance(WelcomeScreen.balance);
			}
		}
		System.out.println("Transaction Succeed");
		fundTransferSummaryScreen.show();
		
	}

}
