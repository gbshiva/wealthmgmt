package com.sag.fin.wealthmgmt.model;

public class Account {
	private String userID;
	private String accountNumber;
	private String accountType;
	private int Balance;
	private int vestedBalance;
	private Holding[] portfolio;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public int getVestedBalance() {
		return vestedBalance;
	}
	public void setVestedBalance(int vestedBalance) {
		this.vestedBalance = vestedBalance;
	}
	public Holding[] getPortfolio() {
		return portfolio;
	}
	public void setPortfolio(Holding[] portfolio) {
		this.portfolio = portfolio;
	}
	public Account(String userID, String accountNumber, String accountType, int balance, int vestedBalance) {
		super();
		this.userID = userID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		Balance = balance;
		this.vestedBalance = vestedBalance;
	}
	public Account(String userID, String accountNumber, String accountType, int balance, int vestedBalance,
			Holding[] portfolio) {
		super();
		this.userID = userID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		Balance = balance;
		this.vestedBalance = vestedBalance;
		this.portfolio = portfolio;
	}
	
}
