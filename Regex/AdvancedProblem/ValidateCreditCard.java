package Regex.AdvancedProblem;

import java.util.regex.*;

public class ValidateCreditCard {
    public static boolean isValidCreditCard(String cardNumber) {
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5[1-5]\\d{14}$";
        return cardNumber.matches(visaRegex) || cardNumber.matches(masterCardRegex);
    }

    public static void main(String[] args) {
        String[] testCards = {"4222222222222", "5500000000000004", "1234567812345678", "5105105105105100", "4000001234567890", "6011000990139424"};
        for (String card : testCards) {
            System.out.println(card + " -> " + (isValidCreditCard(card) ? "Valid" : "Invalid"));
        }
    }
}