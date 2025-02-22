import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankAccountTest {
    BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        bankAccount.deposit(200);
        bankAccount.withdraw(50);
        assertEquals(150, bankAccount.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(50));
    }
}
