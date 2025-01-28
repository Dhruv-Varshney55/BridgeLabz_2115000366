import java.util.Scanner;
public class Program11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();
        double [] roots = findRoots(a, b, c);
        if(roots == null){
            System.out.println("The equation has no real roots.");
        } 
		else if(roots.length == 1){
            System.out.printf("The equation has one root: %.2f%n", roots[0]);
        } 
		else{
            System.out.printf("The equation has two roots: %.2f and %.2f%n", roots[0], roots[1]);
        }
    }
    public static double[] findRoots(double a, double b, double c){
        if(a == 0){
            System.out.println("This is not a quadratic equation.");
            return null;
        }
        double delta = Math.pow(b, 2) - 4 * a * c;
        if(delta > 0){
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        }
		else if(delta == 0){
            double root = -b / (2 * a);
            return new double[]{root};
        }
		else{
            return null;
        }
    }
}