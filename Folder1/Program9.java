import java.util.Scanner;
public class Program9{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value: ");
		int counter = sc.nextInt();
		for(int i=counter; i>=1; i--){
			System.out.println(i);
		}
		System.out.println("Rocket Launched");
	}
}