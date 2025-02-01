public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", "Alice", 1000.00);
        System.out.println("Account Number: " + account.accountNumber + ", Account Holder: " + account.accountHolder + ", Balance: $" + account.getBalance());
        account.setBalance(1500.00);
        System.out.println("Updated Balance: $" + account.getBalance());
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder);
    }
}
