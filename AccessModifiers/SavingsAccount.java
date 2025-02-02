import java.util.Scanner;

class BankAccount{
	
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Rs." + amount + " deposited successfully");
        }
		else{
            System.out.println("Invalid deposit amount");
        }
    }

    public boolean withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Rs." + amount + " withdrawn successfully");
            return true;
        }
		else{
            System.out.println("Insufficient balance or invalid amount");
            return false;
        }
    }

    void displayAccountDetails(){
        System.out.println("\nAccount Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
    }
}


class SavingsAccount extends BankAccount{
	
    private double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate){
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void addInterest(){
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest of Rs." + interest + " added at " + interestRate + "% rate");
    }

    void displaySavingsAccountDetails(){
        displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();
        System.out.print("Enter Initial Balance: Rs.");
        double balance = sc.nextDouble();
        System.out.print("Enter Interest Rate: ");
        double interestRate = sc.nextDouble();
        SavingsAccount sa = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);
        sa.displaySavingsAccountDetails();
        System.out.print("\nEnter deposit amount: Rs.");
        double depositAmount = sc.nextDouble();
        sa.deposit(depositAmount);
        sa.displaySavingsAccountDetails();
        System.out.print("\nEnter withdrawal amount: Rs.");
        double withdrawalAmount = sc.nextDouble();
        sa.withdraw(withdrawalAmount);
        sa.displaySavingsAccountDetails();
        sa.addInterest();
        sa.displaySavingsAccountDetails();
    }
}