import java.util.*;
import java.text.*;

class Policy {
    int policyNumber;
    String policyHolder;
    Date expiryDate;

    public Policy(int policyNumber, String policyHolder, String expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        try {
            this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format");
        }
    }

    @Override
    public String toString() {
        return "Policy{" +
               "policyNumber=" + policyNumber +
               ", policyHolder='" + policyHolder + '\'' +
               ", expiryDate=" + new SimpleDateFormat("yyyy-MM-dd").format(expiryDate) +
               '}';
    }
}

public class InsurancePolicySystem {
    private Map<Integer, Policy> policies = new HashMap<>();
    private LinkedHashMap<Integer, Policy> policyOrder = new LinkedHashMap<>();
    private TreeMap<Date, List<Policy>> expirySortedPolicies = new TreeMap<>();

    public void addPolicy(int number, String holder, String expiry) {
        Policy policy = new Policy(number, holder, expiry);
        policies.put(number, policy);
        policyOrder.put(number, policy);
        expirySortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicy(int policyNumber) {
        return policies.get(policyNumber);
    }

    public List<Policy> getExpiringSoon() {
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_YEAR, 30);
        Date threshold = cal.getTime();

        List<Policy> expiringSoon = new ArrayList<>();
        for (Map.Entry<Date, List<Policy>> entry : expirySortedPolicies.headMap(threshold, true).entrySet()) {
            expiringSoon.addAll(entry.getValue());
        }
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String holder) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyOrder.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holder)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        Date today = new Date();
        expirySortedPolicies.headMap(today, true).clear();
        policies.values().removeIf(policy -> policy.expiryDate.before(today));
        policyOrder.values().removeIf(policy -> policy.expiryDate.before(today));
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();
        system.addPolicy(101, "Dhruv", "2025-03-15");
        system.addPolicy(102, "Vikas", "2024-03-05");
        system.addPolicy(103, "Rishabh", "2024-03-25");
        system.addPolicy(104, "Aditya", "2025-06-10");

        System.out.println("Policy by Number (102): " + system.getPolicy(102));
        System.out.println("Policies expiring soon: " + system.getExpiringSoon());
        System.out.println("Policies for Rishabh: " + system.getPoliciesByHolder("Rishabh"));

        system.removeExpiredPolicies();
        System.out.println("Policies after removing expired ones: " + system.policyOrder.values());
    }
}