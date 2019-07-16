package com.studycase1.services;

import java.util.List;

import com.studycase1.atmsimulation.OtherWithdrawScreen;
import com.studycase1.atmsimulation.SummaryScreen;
import com.studycase1.atmsimulation.TransactionScreen;
import com.studycase1.model.Account;

public interface WithdrawServices {

	// Withdraw Screen
	public void caculateWithdrawAmount(List<Account> users, String accountNumber, String pin,
			SummaryScreen summaryScreen, TransactionScreen transactionScreen, int amount);
	// Other Withdraw Screen

	public void validateAndCalculateWithdrawAmount(String amount, List<Account> users,
			OtherWithdrawScreen otherWithdrawScreen,SummaryScreen summaryScreen);

}
