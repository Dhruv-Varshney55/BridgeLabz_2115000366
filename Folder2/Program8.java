import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter the city you are starting from: ");
        String fromCity = sc.nextLine();
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = sc.nextLine();
        System.out.print("Enter the destination city: ");
        String toCity = sc.nextLine();
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        float fromToVia = sc.nextFloat();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        float viaToFinal = sc.nextFloat();
        System.out.print("Enter the total time taken for the journey (in hours): ");
        float time = sc.nextFloat();
        double distance = fromToVia + viaToFinal;
        double speed = distance / time;
        System.out.println("You traveled from " + fromCity + " to " + toCity + " via " + viaCity + ".");
        System.out.println("The total distance covered is " + distance + " miles.");
        System.out.println("The average speed of your journey was " + speed + " miles per hour.");
    }
}