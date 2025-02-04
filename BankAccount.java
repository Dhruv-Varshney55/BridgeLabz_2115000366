class BankAccount{
    static String bankName = "Indian Overseas Bank";
    static int totalAccounts = 0;
    final int accountNumber;
    String accountHolderName;
    double balance;
    
    BankAccount(String accountHolderName, int accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    
    static void getTotalAccounts(){
        System.out.println("Total Accounts: " + totalAccounts);
    }
    
    void displayAccountDetails(){
        if(this instanceof BankAccount){
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }
    
    public static void main(String[] args){	
        BankAccount acc1 = new BankAccount("Dhruv", 53782, 50000.70);
        BankAccount acc2 = new BankAccount("Vikas", 43574, 35000.50);
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();       
        getTotalAccounts();
    }
}