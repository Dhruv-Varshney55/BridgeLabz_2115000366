import java.util.Scanner;
public class Program9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.println("Choose operation: \n1. Addition \n2. Subtraction \n3. Multiplication \n4. Division");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Addition: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Subtraction: " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Multiplication: " + multiply(num1, num2));
                break;
            case 4:
                if(num2 != 0){
                    System.out.println("Division: " + divide(num1, num2));
                }
				else{
                    System.out.println("Error: Divide by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int subtract(int a, int b){
        return a - b;
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static float divide(float a, float b){
        return a / b;
    }
}