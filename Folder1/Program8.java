import java.util.Scanner;
public class Program8{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int n3 = sc.nextInt();
        int [] ans = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + ans[0] + ", Largest: " + ans[1]);
    }
    public static int[] findSmallestAndLargest(int n1, int n2, int n3){
        int smallest = Math.min(n1, Math.min(n2, n3));
        int largest = Math.max(n1, Math.max(n2, n3));
        return new int[]{smallest, largest};
    }
}