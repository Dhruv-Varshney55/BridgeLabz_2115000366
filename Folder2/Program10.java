import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        System.out.print("Enter the power: ");
        int power = sc.nextInt();
        int result = 1;
        for(int i=1; i<=power; i++){
            result *= num;
        }
        System.out.println(num + " raised to the power of " + power + " is: " + result);
    }
}