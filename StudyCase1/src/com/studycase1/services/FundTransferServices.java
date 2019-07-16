package com.studycase1.services;

import com.studycase1.atmsimulation.FundTransferScreen;
import com.studycase1.atmsimulation.FundTransferSummaryScreen;

public interface FundTransferServices {
	
	// Fund Transfer Screen
	
	 void inputDestinationAccount();
	
	 void inputAmount();
	
	 void inputReferenceNumber();
	 
	 void transferConfirm(FundTransferScreen fundTransferScreen);
	
	//Fund Transfer Summary Screen
	
	 void transaction(FundTransferSummaryScreen fundTransferSummaryScreen);

}
