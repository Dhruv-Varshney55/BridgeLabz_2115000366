import java.util.Scanner;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(checkNumber(n));
    }
	public static int checkNumber(int n){
        if(n > 0){
			return 1;
		}
        if(n < 0){
			return -1;
		}
        return 0;
    }
}