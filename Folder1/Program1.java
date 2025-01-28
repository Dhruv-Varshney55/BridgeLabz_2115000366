import java.util.Scanner;
public class Program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal: ");
        double p = sc.nextDouble();
        System.out.print("Enter Rate: ");
        double r = sc.nextDouble();
        System.out.print("Enter Time: ");
        double t = sc.nextDouble();
        double SI = calculateSI(p, r, t);
        System.out.println("The Simple Interest is " + SI + " for Principal " + p + ", Rate of Interest " + r + " and Time " + t);
    }
	public static double calculateSI(double p, double r, double t){
        return (p * r * t) / 100;
    }
}