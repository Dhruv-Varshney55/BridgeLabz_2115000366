import java.util.Scanner;
public class Conversion{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in kms: ");
        float km = sc.nextFloat();
        float miles = km * 0.621371f;
        System.out.println("Distance in miles is: " + miles);
    }
}