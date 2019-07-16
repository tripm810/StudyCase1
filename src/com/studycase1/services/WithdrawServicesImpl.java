package com.studycase1.services;

import java.util.List;

import com.studycase1.atmsimulation.OtherWithdrawScreen;
import com.studycase1.atmsimulation.SummaryScreen;
import com.studycase1.atmsimulation.TransactionScreen;
import com.studycase1.atmsimulation.WelcomeScreen;
import com.studycase1.atmsimulation.WithdrawScreen;
import com.studycase1.model.Account;

public class WithdrawServicesImpl implements WithdrawServices{

	@Override
	public void caculateWithdrawAmount(List<Account> users, String accountNumber, String pin, SummaryScreen summaryScreen,
			TransactionScreen transactionScreen, int amount) {
		for (int i = 0; i < users.size(); i++) {
			if (WelcomeScreen.accNumberStatic.equals(users.get(i).getAccountNumber())
					&& WelcomeScreen.pinStatic.equals(users.get(i).getPIN()) && users.get(i).getBalance() >= amount) {
				int temp = users.get(i).getBalance();
				users.get(i).setBalance(temp - amount);
				WelcomeScreen.balance = users.get(i).getBalance();
				WithdrawScreen.withdrawAmount = "$" + amount;
				summaryScreen.show();
			} else if (users.get(i).getBalance() < amount) {
				System.out.println("Insufficient balance $" + amount);
				transactionScreen.show();
			}
		}
		
	}

	@Override
	public void validateAndCalculateWithdrawAmount(String amount, List<Account> users, OtherWithdrawScreen otherWithdrawScreen, SummaryScreen summaryScreen) {
		String regex = "[0-9]+";
		if (!amount.matches(regex)) {
			System.out.println("Only Number Allowed");
			otherWithdrawScreen.show();
		}else if (Integer.parseInt(amount) % 10 != 0){
			System.out.println("Invalid ammount");
			otherWithdrawScreen.show();
		} else if (Integer.parseInt(amount) > 1000) {
			System.out.println("Maximum amount to withdraw is $1000");
			otherWithdrawScreen.show();
		} else if (WelcomeScreen.balance - Integer.parseInt(amount) < 0) {
			System.out.println("Insufficient balance $" + amount);
			otherWithdrawScreen.show();
		} else {
		// calculate and set balance
		for (int i = 0; i < users.size(); i++) {
			if (WelcomeScreen.accNumberStatic.equals(users.get(i).getAccountNumber())
					&& WelcomeScreen.pinStatic.equals(users.get(i).getPIN())) {
			users.get(i).setBalance(WelcomeScreen.balance - Integer.parseInt(amount));
			WelcomeScreen.balance -= Integer.parseInt(amount);
			WithdrawScreen.withdrawAmount = "$" + amount;
			summaryScreen.show();
		}
	}
}
		
	}
}
