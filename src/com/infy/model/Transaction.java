package com.infy.model;

import java.time.LocalDate;

public class Transaction {
    private Integer transactionId;
    private String modeOfTransaction;
    private Long receiverAccountNumber;
    private Long senderAccountNumber;
    private LocalDate transactionDate;
    private Double transactionAmount;

    // Constructor, getters, and setters

    public Transaction(Integer transactionId, String modeOfTransaction, Long receiverAccountNumber, Long senderAccountNumber, LocalDate transactionDate, Double transactionAmount) {
        this.transactionId = transactionId;
        this.modeOfTransaction = modeOfTransaction;
        this.receiverAccountNumber = receiverAccountNumber;
        this.senderAccountNumber = senderAccountNumber;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getModeOfTransaction() {
        return modeOfTransaction;
    }

    public void setModeOfTransaction(String modeOfTransaction) {
        this.modeOfTransaction = modeOfTransaction;
    }

    public Long getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(Long receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Long getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(Long senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", modeOfTransaction='" + modeOfTransaction + '\'' +
                ", receiverAccountNumber=" + receiverAccountNumber +
                ", senderAccountNumber=" + senderAccountNumber +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                '}';
    }

}