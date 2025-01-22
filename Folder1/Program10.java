import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your height in cm: ");
        float heightCm = sc.nextFloat();
        float heightInches = heightCm / 2.54f;
        float heightFeet = heightInches / 12;
        System.out.println("Your Height in cm is " + heightCm + " while in feet is " + (int) heightFeet + " and inches is " + (heightInches % 12));
    }
}