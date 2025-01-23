import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value: ");
        int counter = sc.nextInt();
        while(counter >= 1){
            System.out.println(counter);
            counter--;
        }
        System.out.println("Rocket Launched");
    }
}