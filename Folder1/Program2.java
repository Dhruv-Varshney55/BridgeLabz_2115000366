import java.util.Scanner;
public class Program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int a = sc.nextInt();
        System.out.print("Enter the second number: ");
        int b = sc.nextInt();
        System.out.print("Enter the third number: ");
        int c = sc.nextInt();
        int max = maximum(a, b, c);
        System.out.println("The maximum number is: " + max);
    }

    public static int maximum(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }
}