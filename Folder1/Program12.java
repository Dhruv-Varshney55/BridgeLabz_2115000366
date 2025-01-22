import java.util.Scanner;
public class Program12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base of the triangle in cm: ");
        int base = sc.nextInt();
        System.out.print("Enter the height of the triangle in cm: ");
        int height = sc.nextInt();
        float areaCm = 0.5f * base * height;
        float areaInches = areaCm / 6.4516f;
        System.out.println("The area of the triangle in cm2 is " + areaCm + " and in inch2 is " + areaInches);
    }
}
