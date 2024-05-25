package com.infy.service;

import java.util.List;

import com.infy.model.Account;
import com.infy.model.Login;
import com.infy.model.Transaction;

public interface BankService {
	
	String loginUser(Long mobileNo);
    String createAccount(Account account);
    List<Account> viewAllAccounts(Long mobileNo);
    String linkAccount(Long mobileNo, Long accountNo);
    Double checkBalance(Long mobileNo, Long accountNo);
    String fundTransfer(Transaction transaction);
    List<Transaction> viewAllTransactions(Long mobileNo);
    
}