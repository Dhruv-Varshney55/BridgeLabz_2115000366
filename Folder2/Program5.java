import java.util.Scanner;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int num = sc.nextInt();
        if(num > 0){
            for(int i=0; i<=num; i++){
                if(i%3 == 0 && i%5 == 0){
                    System.out.println("FizzBuzz");
                }
				else if(i%3 == 0){
                    System.out.println("Fizz");
                } 
				else if(i%5 == 0){
                    System.out.println("Buzz");
                }
				else{
                    System.out.println(i);
                }
            }
        } 
		else{
            System.out.println("Enter a positive number.");
        }
    }
}