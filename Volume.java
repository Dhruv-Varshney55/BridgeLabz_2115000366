import java.util.Scanner;
public class Volume{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the cylinder: ");
        float r = sc.nextFloat();
        System.out.print("Enter the height of the cylinder: ");
        float h = sc.nextFloat();
        double v = 3.14 * Math.pow(r, 2) * h;
        System.out.println("The volume of the cylinder is: " + v);
    }
}