import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class DependencyInjector{
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public <T> void register(Class<T> clazz) throws Exception{
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        T instance = constructor.newInstance();
        instances.put(clazz, instance);
    }

    public <T> T getInstance(Class<T> clazz) throws Exception{
        T instance = (T) instances.get(clazz);
        if(instance == null){
            register(clazz);
            instance = (T) instances.get(clazz);
        }
        for(Field field : clazz.getDeclaredFields()){
            if(field.isAnnotationPresent(Inject.class)){
                field.setAccessible(true);
                Class<?> dependencyType = field.getType();
                Object dependency = instances.get(dependencyType);
                if(dependency == null){
                    register(dependencyType);
                    dependency = instances.get(dependencyType);
                }
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}

class ServiceA{
    public void doSomething(){
        System.out.println("A is doing something");
    }
}

class ServiceB{
    @Inject
    private ServiceA serviceA;

    public void execute(){
        serviceA.doSomething();
        System.out.println("B executed successfully");
    }
}

public class DependencyInjection{
    public static void main(String[] args) throws Exception{
        DependencyInjector injector = new DependencyInjector();
        injector.register(ServiceA.class);
        injector.register(ServiceB.class);
        ServiceB serviceB = injector.getInstance(ServiceB.class);
        serviceB.execute();
    }
}