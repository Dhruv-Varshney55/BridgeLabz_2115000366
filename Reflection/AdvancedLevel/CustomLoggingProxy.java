import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting{
    void sayHello(String name);
}

class GreetingImpl implements Greeting{
    public void sayHello(String name){
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingProxy implements InvocationHandler{
    private final Object target;

    public LoggingProxy(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        System.out.println("[LOG] Calling method: " + method.getName());
        return method.invoke(target, args);
    }

    public static <T> T createProxy(Class<T> interfaceType, T target){
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingProxy(target)
        );
    }
}

public class CustomLoggingProxy{
    public static void main(String[] args){
        Greeting greeting = new GreetingImpl();
        Greeting proxyGreeting = LoggingProxy.createProxy(Greeting.class, greeting);
        proxyGreeting.sayHello("Dhruv");
    }
}