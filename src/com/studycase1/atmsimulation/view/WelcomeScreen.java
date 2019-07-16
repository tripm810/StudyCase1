package com.studycase1.atmsimulation.view;

import java.util.List;
import java.util.Scanner;

import com.studycase1.atmsilmualtion.services.UserService;
import com.studycase1.atmsilmualtion.services.UserServicesImpl;
import com.studycase1.atmsimulation.model.Account;

public class WelcomeScreen {

	public static String accNumberStatic;
	public static String pinStatic;
	public static int balance;

	public void show() {

		UserService userService = new UserServicesImpl();
		List<Account> users = Account.getInstance();
		WelcomeScreen welcomeScreen = new WelcomeScreen();
		Scanner scan = new Scanner(System.in);

		System.out.println();
		System.out.println("Welcome Screen");
		System.out.println("---------------");

		System.out.print("Enter Account Number: ");
		
		String accountNumber = scan.nextLine();
		String acc = accountNumber;
		accNumberStatic = acc;

		userService.validateAccountNumber(accNumberStatic, users, welcomeScreen);

		System.out.print("Enter PIN: ");
		String pin = scan.nextLine();
		pinStatic = pin;
		
		userService.validatePinNumber(pinStatic, users, welcomeScreen);

		userService.validate(users, accNumberStatic, pinStatic);

	}

}
