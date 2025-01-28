import java.util.Scanner;
public class Program6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Pounds to Kilograms");
        System.out.println("4. Kilograms to Pounds");
        System.out.println("5. Gallons to Liters");
        System.out.println("6. Liters to Gallons");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter Fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                System.out.printf("Celsius: %.2f%n", convertFahrenheitToCelsius(fahrenheit));
                break;
            case 2:
                System.out.print("Enter Celsius: ");
                double celsius = sc.nextDouble();
                System.out.printf("Fahrenheit: %.2f%n", convertCelsiusToFahrenheit(celsius));
                break;
            case 3:
                System.out.print("Enter Pounds: ");
                double pounds = sc.nextDouble();
                System.out.printf("Kilograms: %.2f%n", convertPoundsToKilograms(pounds));
                break;
            case 4:
                System.out.print("Enter Kilograms: ");
                double kilograms = sc.nextDouble();
                System.out.printf("Pounds: %.2f%n", convertKilogramsToPounds(kilograms));
                break;
            case 5:
                System.out.print("Enter Gallons: ");
                double gallons = sc.nextDouble();
                System.out.printf("Liters: %.2f%n", convertGallonsToLiters(gallons));
                break;
            case 6:
                System.out.print("Enter Liters: ");
                double liters = sc.nextDouble();
                System.out.printf("Gallons: %.2f%n", convertLitersToGallons(liters));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static double convertFahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double convertCelsiusToFahrenheit(double celsius){
        return (celsius * 9 / 5) + 32;
    }
    public static double convertPoundsToKilograms(double pounds){
        return pounds * 0.453592;
    }
    public static double convertKilogramsToPounds(double kilograms){
        return kilograms * 2.20462;
    }
    public static double convertGallonsToLiters(double gallons){
        return gallons * 3.78541;
    }
    public static double convertLitersToGallons(double liters){
        return liters * 0.264172;
    }
}