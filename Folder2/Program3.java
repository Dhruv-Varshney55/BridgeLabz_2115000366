import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        if(isLeapYear(year)){
            System.out.println("Leap year");
        }
		else{
            System.out.println("Not a leap year");
        }
    }
	public static boolean isLeapYear(int year){
        if(year>=1582 && ((year%4 == 0 && year%100 != 0) || (year%400 == 0))){
            return true;
        }
        return false;
    }
}