import java.util.Scanner;
public class Program4{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1 of triangular park: ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side2 of triangular park: ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side3 of triangular park: ");
        double s3 = sc.nextDouble();
        double ans = rounds(s1, s2, s3);
		System.out.print("Number of rounds: ");
        System.out.printf("%.2f", ans);
    }
    public static double rounds(double s1, double s2, double s3){
        double perimeter = s1 + s2 + s3;
        return 5000 / perimeter;
    }   
}