package Regex.ReplaceAndModifyString;

public class RemoveExtraSpaces {
    public static void main(String[] args) {
        String input = "This   is   an   example   with   multiple   spaces.";
        String output = input.replaceAll("\\s+", " ");
        System.out.println(output);
    }
}