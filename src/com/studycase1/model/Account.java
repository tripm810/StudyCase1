package com.studycase1.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

		private String Name;
		private String PIN;
		private int Balance;
		private String accountNumber;
		

		
		public  Account(String name, String pIN, int balance, String accountNumber) {
			super();
			Name = name;
			PIN = pIN;
			Balance = balance;
			this.accountNumber = accountNumber;
		}

		private Account () {
			
		}
		
		private static List<Account> users = null; 
		  
	    // static method to create instance of Singleton class 
	    public static List<Account> getInstance() 
	    { 
	        if (users == null) 
	        	users = new ArrayList<>(); 
	  
	        return users; 
	    } 


		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getPIN() {
			return PIN;
		}

		public void setPIN(String pIN) {
			PIN = pIN;
		}

		public int getBalance() {
			return Balance;
		}

		public void setBalance(int balance) {
			Balance = balance;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		
		
}
