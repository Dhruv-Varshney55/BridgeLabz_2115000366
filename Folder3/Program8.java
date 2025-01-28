import java.util.Scanner;
public class Program8{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the month: ");
        int month = sc.nextInt();
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        printCalendar(month, year);
    }
    
    public static String getMonth(int month){
        String[] months = {
            "January", "February", "March", "April", "May", "June", 
            "July", "August", "September", "October", "November", "December"
        };
        return months[month - 1];
    }

    public static int getDays(int month, int year){
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30, 
            31, 31, 30, 31, 30, 31
        };
        if(month == 2 && isLeapYear(year)){
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static boolean isLeapYear(int year){
        if((year%4 == 0 && year%100 != 0) || (year%400 == 0)){
            return true;
        }
        return false;
    }

    public static int getFirstDay(int month, int year){
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + 31 * m0 / 12) % 7;
        return d0;
    }

    public static void printCalendar(int month, int year){
        String monthName = getMonth(month);
        int daysInMonth = getDays(month, year);
        int firstDay = getFirstDay(month, year);
        System.out.println(monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int currentDay = 1;
        for(int i=0; i<firstDay; i++){
            System.out.print("    ");
        }
        for(int i=firstDay; i<7; i++){
            System.out.printf("%3d ", currentDay);
            currentDay++;
        }
        System.out.println();
        while(currentDay <= daysInMonth){
            for(int i=0; i<7; i++){
                if(currentDay > daysInMonth){
                    break;
                }
                System.out.printf("%3d ", currentDay);
                currentDay++;
            }
            System.out.println();
        }
    }
}