import java.util.Scanner;
public class Program9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side1 of the triangle in meters: ");
        int side1 = sc.nextInt();
        System.out.print("Enter side2 of the triangle in meters: ");
        int side2 = sc.nextInt();
        System.out.print("Enter side3 of the triangle in meters: ");
        int side3 = sc.nextInt();
        int perimeter = side1 + side2 + side3;
        float rounds = 5000f / perimeter;
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km");
    }
}
