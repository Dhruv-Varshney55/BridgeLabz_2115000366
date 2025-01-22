import java.util.Scanner;
public class Program7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("The swapped numbers are " + num1 + " and " + num2);
    }
}