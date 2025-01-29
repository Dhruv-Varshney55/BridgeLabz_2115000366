import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println(palindrome(str) ? "Palindrome" : "Not a Palindrome");
    }
    public static boolean palindrome(String str){
        return str.equals(reverseString(str));
    }
    public static String reverseString(String str){
        String reverse = "";
        for(int i=str.length()-1; i>=0; i--){
            reverse += str.charAt(i);
        }
        return reverse;
    }
}