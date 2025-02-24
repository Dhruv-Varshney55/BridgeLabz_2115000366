import java.lang.reflect.Field;

class Person{
    private int age = 22;
}

public class AccessPrivateField{
    public static void main(String[] args){
        try{
            Person p = new Person();
            Class<?> clazz = p.getClass();
            Field f = clazz.getDeclaredField("age");

            f.setAccessible(true);
            System.out.println("Original Age: " + f.get(p));

            f.set(p, 24);
            System.out.println("Modified Age: " + f.get(p));
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}