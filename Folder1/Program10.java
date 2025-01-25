import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive number:");
        int num = sc.nextInt();
        if(num < 0){
            System.out.println("Not a positive number");
            return;
        }
        String [] arr = new String[num + 1];
        for(int i=0; i<=num; i++){
            if(i%3 == 0 && i%5 == 0){
                arr[i] = "FizzBuzz";
            } 
			else if(i%3 == 0){
                arr[i] = "Fizz";
            } 
			else if(i%5 == 0){
                arr[i] = "Buzz";
            } 
			else {
                arr[i] = String.valueOf(i);
            }
        }
        for(int i=0; i<=num; i++){
            System.out.println("Position " + i + " = " + arr[i]);
        }
    }
}