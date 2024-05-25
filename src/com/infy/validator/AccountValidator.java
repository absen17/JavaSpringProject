package com.infy.validator;

import com.infy.exception.BankException;
import com.infy.model.Account;

public class AccountValidator {
	
    public static void validate(Account account) throws BankException {
        validateAccountNumber(account.getAccountNumber());
        validateBankName(account.getBankName());
        validateBalance(account.getBalance());
        validateAccountType(account.getAccountType());
    }

    private static void validateAccountNumber(Long accountNumber) throws BankException {
        String accountStr = accountNumber.toString();
        if (accountStr.length() < 11 || accountStr.length() > 16) {
            throw new BankException("Account number should contain only 11 to 16 digits.");
        }
    }

    private static void validateBankName(String bankName) throws BankException {
        if (!bankName.matches("[a-zA-Z]+")) {
            throw new BankException("Bank name should contain only alphabets.");
        }
    }

    private static void validateBalance(Double balance) throws BankException {
        if (balance < 1000) {
            throw new BankException("Balance should be greater than or equal to 1000.");
        }
    }

    private static void validateAccountType(String accountType) throws BankException {
        if (!accountType.equals("SavingsAccount") && !accountType.equals("SalaryAccount") && !accountType.equals("FixedDeposit")) {
            throw new BankException("Account type can be SavingsAccount/SalaryAccount/FixedDeposit.");
        }
    }
}