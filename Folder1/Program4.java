import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        fibonacci(num);
    }

    public static void fibonacci(int n){
        int first = 0, second = 1, next;
        System.out.println("Fibonacci Sequence:");
        for(int i=0; i<n; i++){
            System.out.print(first + " ");
            next = first + second;
            first = second;
            second = next;
        }
    }
}