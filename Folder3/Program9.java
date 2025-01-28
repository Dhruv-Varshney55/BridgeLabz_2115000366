import java.util.Scanner;
public class Program9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();
        double distance = euclideanDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance between the two points: " + distance);
        double [] equation = lineEquation(x1, y1, x2, y2);
        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", equation[0], equation[1]);
    }
	
	public static double euclideanDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static double[] lineEquation(double x1, double y1, double x2, double y2){
        double [] equation = new double[2];
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        equation[0] = m;
        equation[1] = b;
        return equation;
    }
}