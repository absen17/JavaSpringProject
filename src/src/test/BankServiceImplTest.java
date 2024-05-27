package src.test;

import com.infy.service.BankServiceImpl;
import com.infy.dao.BankDAO;
import com.infy.exception.BankException;
import com.infy.model.Account;
import com.infy.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {

    private BankServiceImpl bankService;
    private BankDAO bankDAO;

    @BeforeEach
    void setUp() {
        bankDAO = new BankDAO(); // Use the actual BankDAO
        bankService = new BankServiceImpl();
    }

    @Test
    void testLoginUser() {
        Long mobileNo = 9876543210L;
        String expectedMessage = "Login successful for mobile number: " + mobileNo;

        String actualMessage = bankService.loginUser(mobileNo);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCreateAccount() {
        Account account = new Account(12345678901L, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), 9876543210L);
        String result = bankService.createAccount(account);
        assertEquals("Account created successfully.", result);

        // Verify the account is actually created
        List<Account> accounts = bankService.viewAllAccounts(9876543210L);
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));
    }

    @Test
    void testViewAllAccounts() {
        Long mobileNo = 9876543210L;
        Account account = new Account(12345678901L, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        bankService.createAccount(account);

        List<Account> accounts = bankService.viewAllAccounts(mobileNo);
        assertEquals(1, accounts.size());
        assertEquals(account, accounts.get(0));
    }

    @Test
    void testLinkAccount() {
        Long mobileNo = 9876543210L;
        Long accountNo = 12345678901L;
        Account account = new Account(accountNo, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        bankService.createAccount(account);

        String result = bankService.linkAccount(mobileNo, accountNo);
        assertEquals("Account linked successfully.", result);
    }

    @Test
    void testCheckBalance() {
        Long mobileNo = 9876543210L;
        Long accountNo = 12345678901L;
        Account account = new Account(accountNo, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        bankService.createAccount(account);

        Double balance = bankService.checkBalance(mobileNo, accountNo);
        assertEquals(5000.0, balance);
    }

    @Test
    void testFundTransfer() {
        Long mobileNo = 9876543210L;
        Long senderAccountNo = 12345678901L;
        Long receiverAccountNo = 10987654321L;
        Account senderAccount = new Account(senderAccountNo, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        Account receiverAccount = new Account(receiverAccountNo, "BankName", 3000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        bankService.createAccount(senderAccount);
        bankService.createAccount(receiverAccount);

        Transaction transaction = new Transaction(1, "BankTransfer", receiverAccountNo, senderAccountNo, LocalDate.now(), 1000.0);
        String result = bankService.fundTransfer(transaction);
        assertEquals("Fund transferred successfully.", result);

        // Verify balances after transfer
        assertEquals(4000.0, bankService.checkBalance(mobileNo, senderAccountNo));
        assertEquals(4000.0, bankService.checkBalance(mobileNo, receiverAccountNo));
    }

    @Test
    void testViewAllTransactions() {
        Long mobileNo = 9876543210L;
        Long senderAccountNo = 12345678901L;
        Long receiverAccountNo = 10987654321L;
        Account senderAccount = new Account(senderAccountNo, "BankName", 5000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        Account receiverAccount = new Account(receiverAccountNo, "BankName", 3000.0, "SavingsAccount", LocalDate.now(), mobileNo);
        bankService.createAccount(senderAccount);
        bankService.createAccount(receiverAccount);

        Transaction transaction = new Transaction(1, "BankTransfer", receiverAccountNo, senderAccountNo, LocalDate.now(), 1000.0);
        bankService.fundTransfer(transaction);

        List<Transaction> transactions = bankService.viewAllTransactions(mobileNo);
        assertEquals(1, transactions.size());
        assertEquals(transaction, transactions.get(0));
    }
}
