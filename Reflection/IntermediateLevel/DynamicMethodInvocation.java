import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations{
    public int add(int a, int b){
        return a + b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }
}

public class DynamicMethodInvocation{
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            MathOperations math = new MathOperations();
            Class<?> clazz = math.getClass();

            System.out.print("Enter method name (add, subtract, multiply): ");
            String methodName = sc.nextLine();

            System.out.print("Enter two integers: ");
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();

            Method m = clazz.getMethod(methodName, int.class, int.class);
            int result = (int) m.invoke(math, n1, n2);

            System.out.println("Result: " + result);
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}