import java.lang.reflect.Method;

class MethodTimer{
    public static void measureExecutionTime(Object obj, String methodName, Object... args){
        try{
            Class<?> clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
            
            long startTime = System.nanoTime();
            method.invoke(obj, args);
            long endTime = System.nanoTime();
            
            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) + " nanoseconds");
			System.out.println();
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}

class SampleClass{
    public void fastMethod(){
        System.out.println("Fast method executed");
    }

    public void slowMethod(){
        try{
            Thread.sleep(100);
        }
		catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Slow method executed");
    }
}

public class MethodExecutionTiming{
    public static void main(String[] args){
        SampleClass obj = new SampleClass();       
        MethodTimer.measureExecutionTime(obj, "fastMethod");
        MethodTimer.measureExecutionTime(obj, "slowMethod");
    }
}