import java.util.*;
public class Program6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter a num: ");
        int num = sc.nextInt();
        System.out.println("Factors: " + Arrays.toString(findFactors(num)));
        System.out.println("Greatest Factor: " + findGreatestFactor(num));
        System.out.println("Sum of Factors: " + sumOfFactors(num));
        System.out.println("Product of Factors: " + productOfFactors(num));
        System.out.println("Product of Cube of Factors: " + productOfCubeOfFactors(num));
        System.out.println("Is Perfect Number: " + isPerfect(num));
        System.out.println("Is Abundant Number: " + isAbundant(num));
        System.out.println("Is Deficient Number: " + isDeficient(num));
        System.out.println("Is Strong Number: " + isStrong(num));
    }

    public static int[] findFactors(int num){
        int [] temp = new int[num];
        int index = 0;
        for(int i=1; i<=num; i++){
            if(num%i == 0){
				temp[index++] = i;
			}
        }
        return Arrays.copyOf(temp, index);
    }

    public static int findGreatestFactor(int num){
        int [] factors = findFactors(num);
        return factors[factors.length - 2];
    }

    public static int sumOfFactors(int num){
        int [] factors = findFactors(num);
        int sum = 0;
        for(int factor : factors){
			sum += factor;
		}
        return sum;
    }

    public static int productOfFactors(int num){
        int [] factors = findFactors(num);
        int product = 1;
        for(int factor : factors){
			product *= factor;
		}
        return product;
    }

    public static double productOfCubeOfFactors(int num){
        int [] factors = findFactors(num);
        double product = 1;
        for(int factor : factors){
			product *= Math.pow(factor, 3);
		}
        return product;
    }

    public static boolean isPerfect(int num){
        return sumOfFactors(num) - num == num;
    }

    public static boolean isAbundant(int num){
        return sumOfFactors(num) - num > num;
    }

    public static boolean isDeficient(int num){
        return sumOfFactors(num) - num < num;
    }

    public static boolean isStrong(int num){
        int [] digits = storeDigits(num);
        int sum = 0;
        for(int digit : digits){
            sum += factorial(digit);
        }
        return sum == num;
    }

    public static int factorial(int n){
        int fact = 1;
        for(int i=2; i<=n; i++){
			fact *= i;
		}
        return fact;
    }

    public static int[] storeDigits(int num){
        String str = String.valueOf(num);
        int [] digits = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            digits[i] = Character.getNumericValue(str.charAt(i));
        }
        return digits;
    }
}