abstract class BankAccount{
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance){
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getHolderName(){
        return holderName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        }
		else{
            System.out.println("Insufficient balance for " + holderName);
        }
    }

    public abstract double calculateInterest();
}

interface Loanable{
    boolean applyForLoan(double amount);
    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount{
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance){
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest(){
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable{
    private static final double INTEREST_RATE = 0.02;
    private double loanLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double loanLimit){
        super(accountNumber, holderName, balance);
        this.loanLimit = loanLimit;
    }

    public double calculateInterest(){
        return getBalance() * INTEREST_RATE;
    }

    public boolean applyForLoan(double amount){
        return amount <= loanLimit;
    }

    public double calculateLoanEligibility(){
        return loanLimit * 0.8;
    }
}

public class BankingSystem{
    public static void processAccount(BankAccount account){
        double interest = account.calculateInterest();
        System.out.println(account.getHolderName() + " = Account No: " + account.getAccountNumber() + ", Balance: " + account.getBalance() + ", Interest: " + interest);
        if(account instanceof Loanable){
            Loanable loanable = (Loanable) account;
            System.out.println(account.getHolderName() + " Loan Eligibility: " + loanable.calculateLoanEligibility());
        }
    }

    public static void main(String[] args){
        BankAccount savings = new SavingsAccount("8473483248334", "Dhruv", 10000);
        BankAccount current = new CurrentAccount("3624742453238", "Vikas", 8000, 50000);
        savings.deposit(1200);
        savings.withdraw(2200);
        current.deposit(6000);
        current.withdraw(10000);
        processAccount(savings);
        processAccount(current);
    }
}