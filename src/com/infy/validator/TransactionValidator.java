package com.infy.validator;

import java.time.LocalDate;

import com.infy.exception.BankException;
import com.infy.model.Transaction;

public class TransactionValidator {
    public static void validate(Transaction transaction) throws BankException {
        validateModeOfTransaction(transaction.getModeOfTransaction());
        validateTransactionDate(transaction.getTransactionDate());
    }

    private static void validateModeOfTransaction(String modeOfTransaction) throws BankException {
        if (!modeOfTransaction.equals("creditCard") && !modeOfTransaction.equals("debitCard") && !modeOfTransaction.equals("BankTransfer") && !modeOfTransaction.equals("MobileBanking")) {
            throw new BankException("Mode of transaction can be either creditCard/debitCard/BankTransfer/MobileBanking.");
        }
    }

    private static void validateTransactionDate(LocalDate transactionDate) throws BankException {
        if (transactionDate.isAfter(LocalDate.now())) {
            throw new BankException("Transaction date should be a past/present date.");
        }
    }
}