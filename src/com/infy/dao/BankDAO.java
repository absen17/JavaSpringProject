package com.infy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infy.model.Account;
import com.infy.model.Transaction;

public class BankDAO {
	// Use collection objects to persist data
	private Map<Long, List<Account>> accountsByMobile = new HashMap<>();
	private Map<Long, List<Transaction>> transactionsByMobile = new HashMap<>();

	public void addAccount(Account account) {
		accountsByMobile.computeIfAbsent(account.getMobileNumber(), k -> new ArrayList<>()).add(account);
	}

	public List<Account> getAccounts(Long mobileNo) {
		return accountsByMobile.getOrDefault(mobileNo, new ArrayList<>());
	}

	public void addTransaction(Transaction transaction) {
		transactionsByMobile.computeIfAbsent(transaction.getSenderAccountNumber(), k -> new ArrayList<>())
				.add(transaction);
	}

	public List<Transaction> getTransactions(Long mobileNo) {
		return transactionsByMobile.getOrDefault(mobileNo, new ArrayList<>());
	}
}
