import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if(isPrime(num)){
            System.out.println("Prime number");
        }
		else{
            System.out.println("Not a prime number");
        }
    }

    public static boolean isPrime(int num){
        if(num <= 1){
			return false;
		}
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0){
				return false;
			}
        }
        return true;
    }
}