import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime { }

class PerformanceTest{
    
    @LogExecutionTime
    public void fastMethod(){
        System.out.println("Executing fast method...");
    }

    @LogExecutionTime
    public void slowMethod(){
        System.out.println("Executing slow method...");
        try{
            Thread.sleep(1000);
        }
		catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void mediumMethod(){
        System.out.println("Executing medium method...");
        for(int i=0; i<1000000; i++){
            Math.sqrt(i);
        }
    }
}

public class MethodExecutionTime{
    public static void main(String[] args) throws Exception{
        PerformanceTest obj = new PerformanceTest();
        Method[] methods = obj.getClass().getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(LogExecutionTime.class)){
                long startTime = System.nanoTime();
                method.invoke(obj);
                long endTime = System.nanoTime();
                long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
                System.out.println("Method: " + method.getName() + " executed in " + duration + " ms");
                System.out.println();
            }
        }
    }
}