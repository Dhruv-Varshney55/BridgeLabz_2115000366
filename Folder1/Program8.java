import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double f = sc.nextDouble();
        System.out.println("Celsius: " + FtoC(f) + "C");
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit: " + CtoF(c) + "F");
    }

    public static double FtoC(double f){
        return (f - 32) * 5 / 9;
    }

    public static double CtoF(double c){
        return (c * 9 / 5) + 32;
    }
}