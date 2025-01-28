import java.util.Scanner;
public class Program2{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if(n <= 0){
            System.out.println("Not a natural number");
            return;
        }
        int recursion = sumRecursion(n);
        int formula = sumFormula(n);
        System.out.println("Sum using Recursion: " + recursion);
        System.out.println("Sum using Formula: " + formula);
        if(recursion == formula){
            System.out.println("Both results are correct");
        }
    }
    public static int sumRecursion(int n){
        if(n == 1){
            return 1;
        }
        return n + sumRecursion(n - 1);
    }
    public static int sumFormula(int n){
        return n * (n + 1) / 2;
    }
}