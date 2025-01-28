import java.util.Scanner;
public class Program10{
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
        System.out.print("Enter x3: ");
        double x3 = sc.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = sc.nextDouble();
        boolean slope = collinearSlope(x1, y1, x2, y2, x3, y3);
        boolean area = collinearArea(x1, y1, x2, y2, x3, y3);
        if(slope && area){
            System.out.println("The points are collinear");
        } 
		else{
            System.out.println("The points are not collinear");
        }
    }
	
	public static boolean collinearSlope(double x1, double y1, double x2, double y2, double x3, double y3){
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return (slopeAB == slopeBC && slopeAB == slopeAC);
    }

    public static boolean collinearArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}