import java.util.Scanner;
public class Program11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Principal: ");
        int principal = sc.nextInt();
        System.out.print("Enter the Rate of Interest: ");
        int rate = sc.nextInt();
        System.out.print("Enter the Time in years: ");
        int time = sc.nextInt();
        float SI = (principal * rate * time) / 100f;
        System.out.println("The Simple Interest is " + SI + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }
}