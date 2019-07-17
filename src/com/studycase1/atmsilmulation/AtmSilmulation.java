package com.studycase1.atmsilmulation;

import java.util.List;

import com.studycase1.atmsilmulation.model.*;
import com.studycase1.atmsilmulation.view.WelcomeScreen;

public class AtmSilmulation {

	public static void main(String[] args) {

		List<Account> users = Account.getInstance();
		users.add(new Account("John Doe", "012108", 100, "112233"));
		users.add(new Account("Jane Doe", "932012", 30, "112244"));

		WelcomeScreen welcomeScreen = new WelcomeScreen();
		while (true) {
		welcomeScreen.show();
		}
	}
}
