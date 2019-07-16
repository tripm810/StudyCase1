package com.studycase1.atmsimulation;

import com.studycase1.services.FundTransferServices;
import com.studycase1.services.FundTransferServicesImpl;

public class FundTransferScreen {
	public static String destinationAcc;
	public static String tranferAmt;
	public static String referenceNum;

	FundTransferServices fundTransferServices = new FundTransferServicesImpl();

	public void show() {

		System.out.println("Transfer Screen");
		System.out.println("----------------");
		fundTransferServices.inputDestinationAccount();

	}

}
