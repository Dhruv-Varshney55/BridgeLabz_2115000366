import java.util.Scanner;
public class Program13{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the perimeter of the square: ");
        int perimeter = sc.nextInt();
        float side = perimeter / 4.0f;
        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}