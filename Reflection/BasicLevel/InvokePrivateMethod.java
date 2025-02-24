import java.lang.reflect.Method;

class Calculator{
    private int multiply(int a, int b){
        return a * b;
    }
}

public class InvokePrivateMethod{
    public static void main(String[] args){
        try{
            Calculator c = new Calculator();
            Class<?> clazz = c.getClass();
            Method m = clazz.getDeclaredMethod("multiply", int.class, int.class);

            m.setAccessible(true);
            int result = (int) m.invoke(c, 7, 9);

            System.out.println("Result: " + result);
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}