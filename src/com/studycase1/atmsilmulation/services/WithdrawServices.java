package com.studycase1.atmsilmulation.services;

import java.util.List;

import com.studycase1.atmsimulation.model.Account;
import com.studycase1.atmsimulation.view.OtherWithdrawScreen;
import com.studycase1.atmsimulation.view.SummaryScreen;
import com.studycase1.atmsimulation.view.TransactionScreen;
import com.studycase1.atmsimulation.view.WithdrawScreen;

public interface WithdrawServices {

	// Withdraw Screen
	public void caculateWithdrawAmount(List<Account> users, String accountNumber, String pin,
			SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount);
	// Other Withdraw Screen

	public void validateAndCalculateWithdrawAmount(String amount, List<Account> users,
			WithdrawScreen withdrawScreen,SummaryScreen summaryScreen);

}
