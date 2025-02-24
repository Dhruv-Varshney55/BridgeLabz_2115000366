import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField{
    String name();
}

class User{
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User(String username, int age, String email){
        this.username = username;
        this.age = age;
        this.email = email;
    }
}

class JsonSerializer{
    public static String serializeToJson(Object obj){
        Map<String, Object> jsonMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for(Field field : fields){
            if(field.isAnnotationPresent(JsonField.class)){
                JsonField jsonField = field.getAnnotation(JsonField.class);
                field.setAccessible(true);
                try{
                    jsonMap.put(jsonField.name(), field.get(obj));
                }
				catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }

        StringBuilder jsonString = new StringBuilder("{");
        for(Map.Entry<String, Object> entry : jsonMap.entrySet()){
            jsonString.append("\"").append(entry.getKey()).append("\": ");
            if(entry.getValue() instanceof String){
                jsonString.append("\"").append(entry.getValue()).append("\", ");
            }
			else{
                jsonString.append(entry.getValue()).append(", ");
            }
        }
        if(jsonString.length() > 1){
			jsonString.setLength(jsonString.length() - 2);
		}
        jsonString.append("}");

        return jsonString.toString();
    }
}

public class CustomSerialization{
    public static void main(String[] args){
        User user = new User("Dhruv", 22, "dhruv@123gmail.com");
        String jsonOutput = JsonSerializer.serializeToJson(user);
        System.out.println(jsonOutput);
    }
}