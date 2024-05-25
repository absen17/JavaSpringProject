package com.infy.model;

import java.time.LocalDate;

public class Account {
	
	private Long accountNumber;
	private String bankName;
	private Double balance;
	private String accountType;
	private LocalDate openingDate;
	private Long mobileNumber;
	public Account(Long accountNumber, String bankName, Double balance, String accountType, LocalDate openingDate,
			Long mobileNumber) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.bankName = bankName;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.mobileNumber = mobileNumber;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	@Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", bankName='" + bankName + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", openingDate=" + openingDate +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}