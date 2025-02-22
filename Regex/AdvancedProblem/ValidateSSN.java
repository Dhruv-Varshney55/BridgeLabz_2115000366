package Regex.AdvancedProblem;

import java.util.regex.*;

public class ValidateSSN {
    public static void main(String[] args) {
        String[] inputs = {"123-45-6789", "123456789"};
        String regex = "^(\\d{3}-\\d{2}-\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        for (String ssn : inputs) {
            Matcher matcher = pattern.matcher(ssn);
            if (matcher.matches()) {
                System.out.println("\"" + ssn + "\" is valid");
            } else {
                System.out.println("\"" + ssn + "\" is invalid");
            }
        }
    }
}