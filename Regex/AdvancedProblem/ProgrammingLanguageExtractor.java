package Regex.AdvancedProblem;

import java.util.*;
import java.util.regex.*;

public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String[] languages = {"Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Ruby", "Swift", "PHP", "Kotlin", "Rust", "TypeScript", "Perl", "Scala", "Dart", "R"};
        String regex = "\\b(" + String.join("|", languages) + ")\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> foundLanguages = new ArrayList<>();
        while (matcher.find()) {
            foundLanguages.add(matcher.group());
        }
        System.out.println(String.join(", ", foundLanguages));
    }
}