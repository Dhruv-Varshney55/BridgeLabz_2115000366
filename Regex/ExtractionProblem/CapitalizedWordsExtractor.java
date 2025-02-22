package Regex.ExtractionProblem;

import java.util.regex.*;
import java.util.*;

public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String capitalizedWordRegex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(capitalizedWordRegex);
        Matcher matcher = pattern.matcher(text);
        List<String> capitalizedWords = new ArrayList<>();
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        System.out.println(String.join(", ", capitalizedWords));
    }
}