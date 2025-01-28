import java.util.Scanner;
public class Program11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature in F: ");
        double temperature = sc.nextDouble();
        System.out.print("Enter the wind speed: ");
        double windSpeed = sc.nextDouble();
        if(windSpeed > 0){
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.printf("The wind chill temperature is: %.2fF\n", windChill);
        } 
		else{
            System.out.println("Wind speed must be greater than zero.");
        }
    }
	public static double calculateWindChill(double temperature, double windSpeed){
        return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
    }
}