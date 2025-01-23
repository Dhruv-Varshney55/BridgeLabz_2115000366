import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amar's age: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter Amar's height in cm: ");
        int amarHeight = sc.nextInt();
        System.out.print("Enter Akbar's height in cm: ");
        int akbarHeight = sc.nextInt();
        System.out.print("Enter Anthony's height in cm: ");
        int anthonyHeight = sc.nextInt();
        int youngest = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        System.out.println("The youngest friend is " + youngest + " years old.");
        int tallest = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        System.out.println("The tallest friend is " + tallest + " cm tall.");
    }
}