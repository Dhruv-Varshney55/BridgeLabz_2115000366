class BankAccount{
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayAccountInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs." + balance);
    }

    public void displayAccountType(){
        System.out.println("General Bank Account");
    }
}

class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void displayAccountType(){
        System.out.println("Account Type: Savings Account");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class CheckingAccount extends BankAccount{
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit){
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void displayAccountType(){
        System.out.println("Account Type: Checking Account");
        System.out.println("Withdrawal Limit: Rs." + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount{
    private int depositTerm;

    public FixedDepositAccount(String accountNumber, double balance, int depositTerm){
        super(accountNumber, balance);
        this.depositTerm = depositTerm;
    }

    @Override
    public void displayAccountType(){
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Deposit Term: " + depositTerm + " months");
    }
}

public class BankManagementSystem{
    public static void main(String[] args){
        SavingsAccount savings = new SavingsAccount("SA-12345", 5000.0, 3.5);
        savings.displayAccountInfo();
        savings.displayAccountType();
		System.out.println("*******************************");
        CheckingAccount checking = new CheckingAccount("CA-67890", 3000.0, 1000.0);
        checking.displayAccountInfo();
        checking.displayAccountType();
		System.out.println("*******************************");
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD-11223", 10000.0, 12);
        fixedDeposit.displayAccountInfo();
        fixedDeposit.displayAccountType();
    }
}