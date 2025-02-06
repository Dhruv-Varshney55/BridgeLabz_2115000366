import java.util.ArrayList;
import java.util.List;

class Bank{
    private String name;
    private List<Customer> customers;

    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(String customerName, double deposit){
        Customer customer = new Customer(customerName, deposit, this);
        customers.add(customer);
        System.out.println("Account opened for " + customerName + " with balance: Rs." + deposit);
    }

    public void showCustomers(){
        System.out.println("\nCustomers of " + name + ":");
        for(Customer customer : customers){
            System.out.println(customer.getName() + " - Balance: Rs." + customer.getBalance());
        }
    }

    public String getName(){
        return name;
    }
}

class Customer{
    private String name;
    private double balance;
    private Bank bank;

    public Customer(String name, double deposit, Bank bank){
        this.name = name;
        this.balance = deposit;
        this.bank = bank;
    }

    public void viewBalance(){
        System.out.println(name + "'s Balance: Rs." + balance);
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }
}

public class BankSystem{
    public static void main(String[] args){
        Bank myBank = new Bank("Indian Overseas Bank");
        myBank.openAccount("Dhruv Varshney", 5000.0);
        myBank.openAccount("Vikas Singh", 2000.0);
        myBank.showCustomers();
    }
}