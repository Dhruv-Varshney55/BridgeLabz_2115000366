package Regex.BasicRegexProblem;

import java.util.Scanner;

public class ValidateUsername {
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();

        if (isValidUsername(username)) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
    }
}
