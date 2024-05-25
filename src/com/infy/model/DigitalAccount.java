package com.infy.model;

public class DigitalAccount {
	
	private String digitalBankingId;
	private Long mobileNumber;
	private Long accountNumber;
	private String accountType;
	
	public DigitalAccount(String digitalBankingId, Long mobileNumber, Long accountNumber, String accountType) {
		super();
		this.digitalBankingId = digitalBankingId;
		this.mobileNumber = mobileNumber;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	public String getDigitalBankingId() {
		return digitalBankingId;
	}

	public void setDigitalBankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	
}