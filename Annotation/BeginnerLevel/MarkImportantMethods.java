import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}

class MyClass{
    
    @ImportantMethod
    public void criticalTask(){
        System.out.println("Executing critical task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void importantTask(){
        System.out.println("Executing important task...");
    }

    public void normalTask(){
        System.out.println("Executing normal task...");
    }
}

public class MarkImportantMethods{
    public static void main(String[] args){
        Class<MyClass> obj = MyClass.class;
        for(Method method : obj.getDeclaredMethods()){
            if(method.isAnnotationPresent(ImportantMethod.class)){
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}