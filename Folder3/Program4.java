import java.util.*;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter a num: ");
        int num = sc.nextInt();
        System.out.println("Count of Digits: " + countDigits(num));
        System.out.println("Digits Array: " + Arrays.toString(storeDigits(num)));
        System.out.println("Reversed Digits: " + Arrays.toString(reverseDigits(storeDigits(num))));
		System.out.println("Are Arrays Equal: " + areArraysEqual(storeDigits(num), reverseDigits(storeDigits(num))));
        System.out.println("Is Palindrome: " + isPalindrome(num));
        System.out.println("Is Duck Number: " + isDucknum(num));
    }

    public static int countDigits(int num){
        return String.valueOf(num).length();
    }

    public static int[] storeDigits(int num){
        String str = String.valueOf(num);
        int [] digits = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }

    public static int[] reverseDigits(int[] digits){
        int [] reversed = new int[digits.length];
        for(int i=0; i<digits.length; i++){
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

	public static boolean areArraysEqual(int[] array1, int[] array2){
        return Arrays.equals(array1, array2);
    }

    public static boolean isPalindrome(int num){
        int[] digits = storeDigits(num);
        return Arrays.equals(digits, reverseDigits(digits));
    }

    public static boolean isDucknum(int num){
        String str = String.valueOf(num);
        return str.contains("0") && str.charAt(0) != '0';
    }
}