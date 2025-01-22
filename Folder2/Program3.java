import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value for a: ");
        double a = sc.nextDouble();
        System.out.print("Enter value for b: ");
        double b = sc.nextDouble();
        System.out.print("Enter value for c: ");
        double c = sc.nextDouble();
        double res1 = a + b * c;
        double res2 = a * b + c;
        double res3 = c + a / b;
        double res4 = a % b + c;
        System.out.println("The results of Double Operations are " + res1 + ", " + res2 + ", " + res3 + ", and " + res4);
    }
}