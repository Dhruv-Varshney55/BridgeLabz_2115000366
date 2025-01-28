import java.util.*;
public class Program2{
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Count of Digits: " + count(num));
        System.out.println("Digits Array: " + Arrays.toString(store(num)));
        System.out.println("Is Duck Number: " + duck(num));
        System.out.println("Is Armstrong Number: " + armstrong(num));
        int [] digits = store(num);
        System.out.println("Largest Element: " + findLargest(digits));
        System.out.println("Second Largest Element: " + findSecondLargest(digits));
        System.out.println("Smallest Element: " + findSmallest(digits));
        System.out.println("Second Smallest Element: " + findSecondSmallest(digits));
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

    public static boolean duck(int num){
        String str = String.valueOf(num);
        return str.contains("0");
    }

    public static boolean armstrong(int num){
        int [] digits = store(num);
        int sum = 0;
        for(int digit : digits){
            sum += Math.pow(digit, digits.length);
        }
        return sum == num;
    }

    public static int findLargest(int[] digits){
        int largest = Integer.MIN_VALUE;
        for(int digit : digits){
            largest = Math.max(largest, digit);
        }
        return largest;
    }

    public static int findSecondLargest(int[] digits){
        int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
        for(int digit : digits){
            if(digit > largest){
                secondLargest = largest;
                largest = digit;
            }
			else if(digit > secondLargest && digit != largest){
                secondLargest = digit;
            }
        }
        return secondLargest;
    }

    public static int findSmallest(int[] digits){
        int smallest = Integer.MAX_VALUE;
        for(int digit : digits){
            smallest = Math.min(smallest, digit);
        }
        return smallest;
    }

    public static int findSecondSmallest(int[] digits){
        int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
        for(int digit : digits){
            if(digit < smallest){
                secondSmallest = smallest;
                smallest = digit;
            } 
			else if(digit < secondSmallest && digit != smallest){
                secondSmallest = digit;
            }
        }
        return secondSmallest;
    }
}