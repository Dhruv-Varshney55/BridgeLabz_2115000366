import java.util.Scanner;
public class Area{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        float r = sc.nextFloat();
        double a = 3.14 * Math.pow(r, 2);
        System.out.println("The area of the circle is: " + a);
    }
}
