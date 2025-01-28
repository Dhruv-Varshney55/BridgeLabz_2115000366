import java.util.Scanner;
public class Program2{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of students: ");
        int n = sc.nextInt();
        int ans = handshakes(n);
        System.out.println("Maximum number of handshakes: " + ans);
    }
    public static int handshakes(int n){
        return (n * (n - 1)) / 2;
    }
}