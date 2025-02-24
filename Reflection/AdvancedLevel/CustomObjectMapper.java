import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class ObjectMapper{
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties){
        try{
            T instance = clazz.getDeclaredConstructor().newInstance();
            for(Map.Entry<String, Object> entry : properties.entrySet()){
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();
                try{
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, fieldValue);
                }
				catch(NoSuchFieldException e){
                    System.out.println("Field not found: " + fieldName);
                }
            }
            return instance;
        }
		catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

class User{
    private String name;
    private int age;

    public void display(){
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomObjectMapper{
    public static void main(String[] args){
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Dhruv");
        data.put("age", 22);
        User user = ObjectMapper.toObject(User.class, data);
        if(user != null){
            user.display();
        }
    }
}