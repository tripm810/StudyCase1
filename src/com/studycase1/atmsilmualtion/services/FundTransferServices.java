package com.studycase1.atmsilmualtion.services;

import java.util.List;

import com.studycase1.atmsimulation.model.Account;
import com.studycase1.atmsimulation.view.FundTransferScreen1;
import com.studycase1.atmsimulation.view.TransactionScreen;

public interface FundTransferServices {
	
	// Fund Transfer Screen
	
	 void inputDestinationAccount();
	
	 void inputAmountScreen();
	
	 void inputReferenceNumberScreen();
	 
	 void transferConfirmScreen(FundTransferScreen1 fundTransferScreen, List<Account> users);
	
	//Fund Transfer Summary Screen
	
	 void transaction(TransactionScreen transactionScreen);

	 boolean isExists(List<Account> users);
	 
	 void addAmountToDestination(List<Account> users);
}
