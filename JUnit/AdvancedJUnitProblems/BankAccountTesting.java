package JUnit.AdvancedJUnitProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTesting {
    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount(1000.0);
    }

    @AfterEach
    void tearDown() {
        bankAccount = null;
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(500.0);
        assertEquals(1500.0, bankAccount.getBalance());
    }

    @Test
    void testWithdrawSuccess() {
        assertTrue(bankAccount.withdraw(400.0));
        assertEquals(600.0, bankAccount.getBalance());
    }

    @Test
    void testWithdrawFailure() {
        assertFalse(bankAccount.withdraw(2000.0));
        assertEquals(1000.0, bankAccount.getBalance());
    }
}