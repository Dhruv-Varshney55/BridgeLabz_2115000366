import java.util.Scanner;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        if(isPalindrome(input)){
            System.out.println("Palindrome");
        }
		else{
            System.out.println("Not a palindrome");
        }
    }

    public static boolean isPalindrome(String str){
        str = str.toLowerCase();
        int left = 0, right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}