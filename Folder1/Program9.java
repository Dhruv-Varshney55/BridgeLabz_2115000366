import java.util.Scanner;
public class Program9{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the dividend: ");
        int number = sc.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = sc.nextInt();
        int [] ans = findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + ans[0] + ", Remainder: " + ans[1]);
    }
    public static int [] findRemainderAndQuotient(int number, int divisor){
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }
}