import java.util.Scanner;
public class Power{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int b = sc.nextInt();
        System.out.print("Enter the exponent: ");
        int e = sc.nextInt();
        double ans = Math.pow(b, e);
        System.out.println("Result: " + ans);
    }
}