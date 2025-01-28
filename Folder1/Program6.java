import java.util.Scanner;
public class Program6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        System.out.print("Enter the day: ");
        int day = sc.nextInt();
        boolean ans = springSeason(month, day);
        System.out.println(ans ? "It's a Spring Season" : "Not a Spring Season");
    }
	public static boolean springSeason(int month, int day){
        return (month == 3 && day >= 20) || (month == 6 && day <= 20) || (month > 3 && month < 6);
    }
}