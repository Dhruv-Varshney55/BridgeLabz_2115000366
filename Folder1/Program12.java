import java.util.Scanner;
public class Program12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the angle in degrees: ");
        double angle = sc.nextDouble();
        double [] ans = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.2f%n", ans[0]);
        System.out.printf("Cosine: %.2f%n", ans[1]);
        System.out.printf("Tangent: %.2f%n", ans[2]);
    }
	public static double [] calculateTrigonometricFunctions(double angle){
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }
}