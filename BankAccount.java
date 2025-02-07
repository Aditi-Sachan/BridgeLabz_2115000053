class BankAccount{

   String accountNumber;

	double balance;

	public BankAccount(String accountNumber,double balance){

		this.accountNumber=accountNumber;

		this.balance=balance;

	}

	public void displayAccountInfo(){

		System.out.println("Account Number --> "+accountNumber);

		System.out.println("Balance --> $"+balance);

	}

}

class savingAccount extends BankAccount{

	double interestRate;

	public savingAccount(String accountNumber,double balance,double interestRate){

		super(accountNumber,balance);

		this.interestRate=interestRate;

	}

	public void displayAccountType(){

		System.out.println("Account Type --> saving Account");

		System.out.println("Interest Rate --> "+interestRate+"%");

	}

}

class CheckingAccount extends BankAccount{

	double withdrawalLimit;

	public CheckingAccount(String accountNumber,double balance,double withdrawalLimit){

		super(accountNumber,balance);

		this.withdrawalLimit=withdrawalLimit;

	}

	public void displayAccountType(){

		System.out.println("Account Type --> Checking Account");

		System.out.println("Withdrawal Limit --> $"+withdrawalLimit);

	}

}

class FixedDepositAccount extends BankAccount{

	int tenure;

	public FixedDepositAccount(String accountNumber,double balance,int tenure){

		super(accountNumber,balance);

		this.tenure=tenure;

	}

	public void displayAccountType(){

		System.out.println("Account Type --> Fixed Deposit Account");

		System.out.println("Tenure --> "+tenure+" months");

	}

}

public class BankAccountTypes{

	public static void main(String[] args){

		savingAccount saving=new savingAccount("SA-1",1000,5.0);

		CheckingAccount checking=new CheckingAccount("CA-1",500,1000.0);

		FixedDepositAccount fixedDeposit=new FixedDepositAccount("FD-1",5000,12);

		saving.displayAccountInfo();

		saving.displayAccountType();

		System.out.println();

		checking.displayAccountInfo();

		checking.displayAccountType();

		System.out.println();

		fixedDeposit.displayAccountInfo();

		fixedDeposit.displayAccountType();

	}

}
