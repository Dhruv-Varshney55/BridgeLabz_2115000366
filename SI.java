import java.util.Scanner;
public class SI{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Principal: ");
        float p = sc.nextFloat();
        System.out.print("Enter the Rate: ");
        float r = sc.nextFloat();
        System.out.print("Enter the Time: ");
        float t = sc.nextFloat();
        float si = (p * r * t) / 100;
        System.out.println("SI is: " + si);
    }
}