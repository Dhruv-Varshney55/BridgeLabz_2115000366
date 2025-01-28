import java.util.Scanner;
public class Program5{
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a conversion:");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        double result;
        switch(choice){
            case 1:
                System.out.print("Enter yards: ");
                double yards = sc.nextDouble();
                System.out.printf("Feet: %.2f%n", convertYardsToFeet(yards));
                break;
            case 2:
                System.out.print("Enter feet: ");
                double feet = sc.nextDouble();
                System.out.printf("Yards: %.2f%n", convertFeetToYards(feet));
                break;
            case 3:
                System.out.print("Enter meters: ");
                double meters = sc.nextDouble();
                System.out.printf("Inches: %.2f%n", convertMetersToInches(meters));
                break;
            case 4:
                System.out.print("Enter inches: ");
                double inches = sc.nextDouble();
                System.out.printf("Meters: %.2f%n", convertInchesToMeters(inches));
                break;
            case 5:
                System.out.print("Enter inches: ");
                inches = sc.nextDouble();
                System.out.printf("Centimeters: %.2f%n", convertInchesToCentimeters(inches));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static double convertYardsToFeet(double yards){
        double yards2feet = 3;
        return yards * yards2feet;
    }
    public static double convertFeetToYards(double feet){
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    public static double convertMetersToInches(double meters){
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    public static double convertInchesToMeters(double inches){
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    public static double convertInchesToCentimeters(double inches){
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
}