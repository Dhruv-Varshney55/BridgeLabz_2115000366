import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Conversion: ");
        System.out.println("1. Kilometers to Miles");
        System.out.println("2. Miles to Kilometers");
        System.out.println("3. Meters to Feet");
        System.out.println("4. Feet to Meters");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter Kilometers: ");
                double km = sc.nextDouble();
                System.out.printf("Miles: %.2f%n", convertKmToMiles(km));
                break;
            case 2:
                System.out.print("Enter Miles: ");
                double miles = sc.nextDouble();
                System.out.printf("Kilometers: %.2f%n", convertMilesToKm(miles));
                break;
            case 3:
                System.out.print("Enter Meters: ");
                double meters = sc.nextDouble();
                System.out.printf("Feet: %.2f%n", convertMetersToFeet(meters));
                break;
            case 4:
                System.out.print("Enter Feet: ");
                double feet = sc.nextDouble();
                System.out.printf("Meters: %.2f%n", convertFeetToMeters(feet));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
	public static double convertKmToMiles(double km){
        double km2miles = 0.621371;
        return km * km2miles;
    }
    public static double convertMilesToKm(double miles){
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    public static double convertMetersToFeet(double meters){
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    public static double convertFeetToMeters(double feet){
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}