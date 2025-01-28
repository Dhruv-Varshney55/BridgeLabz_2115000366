import java.util.*;
public class Program3{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Count of Digits: " + count(num));
        System.out.println("Digits Array: " + Arrays.toString(store(num)));
        System.out.println("Sum of Digits: " + sumOfDigits(num));
        System.out.println("Sum of Squares of Digits: " + sumOfSquaresOfDigits(num));
        System.out.println("Is Harshad Number: " + isHarshadnum(num));
        int[] frequency = findDigitFrequency(num);
        System.out.println("Digit Frequency: ");
        for(int i=0; i<frequency.length; i++){
            if(frequency[i] > 0){
                System.out.println(i + ": " + frequency[i]);
            }
        }
    }
	
	public static int count(int num){
        return String.valueOf(num).length();
    }
    
	public static int[] store(int num){
        String str = String.valueOf(num);
        int [] digits = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }
		
    public static int sumOfDigits(int num){
        int [] digits = store(num);
        int sum = 0;
        for(int digit : digits){
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int num){
        int [] digits = store(num);
        int sum = 0;
        for(int digit : digits){
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadnum(int num){
        int sum = sumOfDigits(num);
        return num % sum == 0;
    }

    public static int[] findDigitFrequency(int num){
        int [] digits = store(num);
        int [] frequency = new int[10];
        for(int digit : digits){
            frequency[digit]++;
        }
        return frequency;
    }   
}