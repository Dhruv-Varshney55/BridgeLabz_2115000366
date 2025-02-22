package Regex.AdvancedProblem;

import java.util.*;
import java.util.regex.*;

public class CurrencyExtractor {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> currencyValues = new ArrayList<>();
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        System.out.println(String.join(", ", currencyValues));
    }
}