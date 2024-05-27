package com.infy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infy.exception.BankException;
import com.infy.model.Account;
import com.infy.model.Transaction;
import com.infy.validator.AccountValidator;
import com.infy.validator.TransactionValidator;

public class BankServiceImpl implements BankService {
    private Map<Long, List<Account>> accountMap = new HashMap<>();
    private Map<Long, List<Transaction>> transactionMap = new HashMap<>();

    @Override
    public String loginUser(Long mobileNo) {
        // Implementation user login
        return "Login successful for mobile number: " + mobileNo;
    }

    @Override
    public String createAccount(Account account) {
        try {
            AccountValidator.validate(account);
            accountMap.computeIfAbsent(account.getMobileNumber(), k -> new ArrayList<>()).add(account);
            return "Account created successfully!";
        } catch (BankException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Account> viewAllAccounts(Long mobileNo) {
        return accountMap.getOrDefault(mobileNo, new ArrayList<>());
    }

    @Override
    public String linkAccount(Long mobileNo, Long accountNo) {
        // Implementation for linking account
        return "Account linked successfully!";
    }

    @Override
    public Double checkBalance(Long mobileNo, Long accountNo) {
        List<Account> accounts = accountMap.get(mobileNo);
        if (accounts != null) {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNo)) {
                    return account.getBalance();
                }
            }
        }
        return 0.0;
    }

    @Override
    public String fundTransfer(Transaction transaction) {
        try {
            TransactionValidator.validate(transaction);
            transactionMap.computeIfAbsent(transaction.getSenderAccountNumber(), k -> new ArrayList<>()).add(transaction);
            return "Transaction successful!";
        } catch (BankException e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Transaction> viewAllTransactions(Long mobileNo) {
        List<Account> accounts = accountMap.get(mobileNo);
        List<Transaction> transactions = new ArrayList<>();
        if (accounts != null) {
            for (Account account : accounts) {
                List<Transaction> accountTransactions = transactionMap.get(account.getAccountNumber());
                if (accountTransactions != null) {
                    transactions.addAll(accountTransactions);
                }
            }
        }
        return transactions;
    }
}