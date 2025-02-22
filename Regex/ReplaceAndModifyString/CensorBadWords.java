package Regex.ReplaceAndModifyString;

import java.util.Arrays;
import java.util.List;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        System.out.println(input);
    }
}