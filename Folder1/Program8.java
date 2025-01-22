import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        int km = sc.nextInt();
        float miles = km / 1.6f;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}