import java.util.Scanner;
public class Perimeter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        int l = sc.nextInt();
        System.out.print("Enter the breadth of the rectangle: ");
        int b = sc.nextInt();
        int p = 2 * (l + b);
        System.out.println("Perimeter: " + p);
    }
}