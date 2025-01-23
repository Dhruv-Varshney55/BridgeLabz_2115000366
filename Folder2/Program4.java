import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(num <= 1){
            System.out.println("Not a prime number");
        } 
		else{
            boolean prime = true;
            for(int i=2; i<=Math.sqrt(num); i++){
                if(num%i == 0){
                    prime = false;
                    break;
                }
            }
            System.out.println(num + (prime ? " is a prime number" : " is not a prime number"));
        }
    }
}