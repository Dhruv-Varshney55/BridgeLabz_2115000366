import java.util.Scanner;
public class Program12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number below 100: ");
        int num = sc.nextInt();
        System.out.println("Multiples of " + num + " below 100 are:");
        for(int i=100; i>=1; i--){
            if(i%num == 0){
                System.out.println(i);
            }
        }
    }
}