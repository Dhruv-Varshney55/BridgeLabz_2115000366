import java.util.*;
public class BankingSystem {
    private Map<Integer, Double> accounts = new HashMap<>();
    private Queue<Integer> withdrawalQueue = new LinkedList<>();

    public void createAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void deposit(int accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    public void requestWithdrawal(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            int account = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account: " + account);
        }
    }

    public Map<Double, List<Integer>> getSortedAccountsByBalance() {
        TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();
        for (var entry : accounts.entrySet()) {
            sortedAccounts.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return sortedAccounts;
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.createAccount(101, 10000.0);
        bank.createAccount(102, 30000.0);
        bank.createAccount(103, 40000.0);
        bank.deposit(101, 5000.0);
        bank.requestWithdrawal(102);
        bank.requestWithdrawal(103);
        System.out.println("Sorted Accounts by Balance: " + bank.getSortedAccountsByBalance());
        bank.processWithdrawals();
    }
}