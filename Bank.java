import java.util.ArrayList;
import java.util.List;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountNumber() + " Balance: " + account.getBalance());
        }
    }
}

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, Account account) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        customer.addAccount(account);
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        Account account1 = new Account("12345", 1000.0);
        Account account2 = new Account("67890", 2000.0);
        
        bank.openAccount(customer1, account1);
        bank.openAccount(customer2, account2);
        
        customer1.viewBalance();
        customer2.viewBalance();
    }
}

