abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract void calculateInterest();
    
    public double getBalance() {
        return balance;
    }
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void calculateInterest() {
        balance += balance * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private boolean loanApproved;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
        this.loanApproved = false;
    }

    public void calculateInterest() {
        balance += balance * INTEREST_RATE;
    }

    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            balance += amount;
            loanApproved = true;
        }
    }

    public boolean calculateLoanEligibility() {
        return balance >= 5000;
    }
}

class BankingSystem {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("12345", "Alice", 10000);
        BankAccount current = new CurrentAccount("67890", "Bob", 8000);

        savings.deposit(2000);
        current.withdraw(1000);

        savings.calculateInterest();
        current.calculateInterest();

        Loanable loanAccount = (Loanable) current;
        loanAccount.applyForLoan(5000);
    }
}
