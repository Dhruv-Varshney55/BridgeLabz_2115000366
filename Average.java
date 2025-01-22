import java.util.Scanner;
public class Average{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("First number: ");
		float x = sc.nextFloat();
        System.out.print("Second number: ");
        float y = sc.nextFloat();
        System.out.print("Third number: ");
        float z = sc.nextFloat();
        float avg = (x + y + z) / 3;
        System.out.println("The average is: " + avg);
    }
}