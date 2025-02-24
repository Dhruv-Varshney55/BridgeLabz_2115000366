import java.lang.reflect.Constructor;

class Student{
    public Student(){
        System.out.println("Student object created dynamically");
    }
}

public class DynamicallyCreateObject{
    public static void main(String[] args){
        try{
            Class<?> clazz = Class.forName("Student");
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            Object student = constructor.newInstance();
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}