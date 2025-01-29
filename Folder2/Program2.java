import java.time.LocalDate;
import java.util.Scanner;
public class Program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String str = sc.nextLine();
        LocalDate date = LocalDate.parse(str);
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        System.out.println("Updated Date: " + updatedDate);
    }
}