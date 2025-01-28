import java.util.*;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter a num: ");
        int num = sc.nextInt();
        System.out.println("Is Prime Number: " + isPrime(num));
        System.out.println("Is Neon Number: " + isNeon(num));
        System.out.println("Is Spy Number: " + isSpy(num));
        System.out.println("Is Automorphic Number: " + isAutomorphic(num));
        System.out.println("Is Buzz Number: " + isBuzz(num));
    }

    public static boolean isPrime(int num){
        if(num <= 1){
			return false;
		} 
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
				return false;
			}
        }
        return true;
    }

    public static boolean isNeon(int num){
        int square = num * num;
        int sum = 0;
        while(square > 0){
            sum += square % 10;
            square /= 10;
        }
        return sum == num;
    }

    public static boolean isSpy(int num){
        int [] digits = storeDigits(num);
        int sum = 0, product = 1;
        for(int digit : digits){
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int num){
        String numStr = String.valueOf(num);
        String squareStr = String.valueOf(num * num);
        return squareStr.endsWith(numStr);
    }

    public static boolean isBuzz(int num){
        return num%7 == 0 || num%10 == 7;
    }

    private static int[] storeDigits(int num){
        String str = String.valueOf(num);
        int [] digits = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }
}