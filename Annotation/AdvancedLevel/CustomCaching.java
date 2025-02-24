import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class CacheManager{
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeCachedMethod(Object obj, String methodName, Object... args){
        try{
            Method method = obj.getClass().getMethod(methodName, int.class);
            if(method.isAnnotationPresent(CacheResult.class)){
                String key = methodName + "(" + args[0] + ")";
                if(cache.containsKey(key)){
                    System.out.println("Returning cached result for: " + key);
                    return cache.get(key);
                }
                Object result = method.invoke(obj, args);
                cache.put(key, result);
                return result;
            }
			else{
                return method.invoke(obj, args);
            }
        }
		catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

class ExpensiveOperations{
    @CacheResult
    public int factorial(int n){
        System.out.println("Computing factorial for: " + n);
        if(n==0 || n==1){
			return 1;
		}
        return n * factorial(n - 1);
    }
}

public class CustomCaching{
    public static void main(String[] args){
        ExpensiveOperations operations = new ExpensiveOperations();
        System.out.println("Result: " + CacheManager.invokeCachedMethod(operations, "factorial", 5));
        System.out.println("Result: " + CacheManager.invokeCachedMethod(operations, "factorial", 5));
        System.out.println("Result: " + CacheManager.invokeCachedMethod(operations, "factorial", 6));
    }
}