package com.infy.userInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.infy.model.Account;
import com.infy.model.Transaction;
import com.infy.service.BankService;
import com.infy.service.BankServiceImpl;

public class InfyMobileApplication {
	private static BankService bankService = new BankServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. View All Accounts");
            System.out.println("4. Link Account");
            System.out.println("5. Check Balance");
            System.out.println("6. Fund Transfer");
            System.out.println("7. View All Transactions");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginUser();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    viewAllAccounts();
                    break;
                case 4:
                    linkAccount();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    fundTransfer();
                    break;
                case 7:
                    viewAllTransactions();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 8);

        scanner.close();
    }

    private static void loginUser() {
        System.out.print("Enter mobile number: ");
        Long mobileNo = scanner.nextLong();
        System.out.println(bankService.loginUser(mobileNo));
    }

    private static void createAccount() {
        System.out.print("Enter account number: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter bank name: ");
        String bankName = scanner.nextLine();
        System.out.print("Enter balance: ");
        Double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter account type: ");
        String accountType = scanner.nextLine();
        System.out.print("Enter mobile number: ");
        Long accMobileNo = scanner.nextLong();
        Account account = new Account(accountNumber, bankName, balance, accountType, LocalDate.now(), accMobileNo);
        System.out.println(bankService.createAccount(account));
    }

    private static void viewAllAccounts() {
        System.out.print("Enter mobile number: ");
        Long mobileNo = scanner.nextLong();
        List<Account> accounts = bankService.viewAllAccounts(mobileNo);
        accounts.forEach(System.out::println);
    }

    private static void linkAccount() {
        System.out.print("Enter mobile number: ");
        Long mobileNo = scanner.nextLong();
        System.out.print("Enter account number: ");
        Long accountNumber = scanner.nextLong();
        System.out.println(bankService.linkAccount(mobileNo, accountNumber));
    }

    private static void checkBalance() {
        System.out.print("Enter mobile number: ");
        Long mobileNo = scanner.nextLong();
        System.out.print("Enter account number: ");
        Long accountNumber = scanner.nextLong();
        System.out.println("Balance: " + bankService.checkBalance(mobileNo, accountNumber));
    }

    private static void fundTransfer() {
        System.out.print("Enter transaction ID: ");
        Integer transactionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter mode of transaction: ");
        String modeOfTransaction = scanner.nextLine();
        System.out.print("Enter receiver account number: ");
        Long receiverAccountNumber = scanner.nextLong();
        System.out.print("Enter sender account number: ");
        Long senderAccountNumber = scanner.nextLong();
        System.out.print("Enter transaction amount: ");
        Double transactionAmount = scanner.nextDouble();
        Transaction transaction = new Transaction(transactionId, modeOfTransaction, receiverAccountNumber, senderAccountNumber, LocalDate.now(), transactionAmount);
        System.out.println(bankService.fundTransfer(transaction));
    }

    private static void viewAllTransactions() {
        System.out.print("Enter mobile number: ");
        Long mobileNo = scanner.nextLong();
        List<Transaction> transactions = bankService.viewAllTransactions(mobileNo);
        for(Transaction transaction: transactions) {
        	System.out.println(transaction);
        }
    }
}
