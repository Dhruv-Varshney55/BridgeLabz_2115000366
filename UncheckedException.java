import java.util.Scanner;
import java.util.InputMismatchException;
public class UncheckedException{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter numerator: ");
            int num = sc.nextInt();
            System.out.print("Enter denominator: ");
            int den = sc.nextInt();
            int ans = num / den;
            System.out.println("Result: " + ans);
        }
		catch(ArithmeticException e){
            System.out.println("Error: Division by zero is not allowed");
        }
		catch(InputMismatchException e){
            System.out.println("Error: Please enter numeric values only");
        }
    }
}