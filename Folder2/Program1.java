import java.util.Scanner;
public class Program1{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int [] arr = findFactors(n);
        System.out.println("Factors: ");
        for(int factor : arr){
            System.out.print(factor + " ");
        }
        System.out.println();
        System.out.println("Sum of factors: " + sumOfarr(arr));
        System.out.println("Product of factors: " + productOfArr(arr));
        System.out.println("Sum of Squares of factors: " + sumOfSquaresOfArr(arr));
    }
    public static int [] findFactors(int n){
        int c = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                c++;
            }
        }
        int [] arr = new int[c];
        int index = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                arr[index++] = i;
            }
        }
        return arr;
    }
    public static int sumOfarr(int [] arr){
        int sum = 0;
        for(int factor : arr){
            sum += factor;
        }
        return sum;
    }
    public static long productOfArr(int [] arr){
        long p = 1;
        for(int factor : arr){
            p *= factor;
        }
        return p;
    }
    public static int sumOfSquaresOfArr(int [] arr){
        int sum = 0;
        for(int factor : arr){
            sum += Math.pow(factor, 2);
        }
        return sum;
    }
}