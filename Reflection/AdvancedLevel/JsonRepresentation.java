import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class JsonSerializer{
    public static String toJson(Object obj){
        if(obj == null){
            return "null";
        }

        Class<?> clazz = obj.getClass();
        Map<String, String> jsonMap = new HashMap<>();
        try{
            for(Field field : clazz.getDeclaredFields()){
                field.setAccessible(true);
                Object value = field.get(obj);
                jsonMap.put(field.getName(), formatValue(value));
            }
        }
		catch(IllegalAccessException e){
            e.printStackTrace();
        }

        return buildJsonString(jsonMap);
    }

    private static String formatValue(Object value){
        if(value instanceof String){
            return "\"" + value + "\"";
        }
        return String.valueOf(value);
    }

    private static String buildJsonString(Map<String, String> jsonMap){
        StringBuilder json = new StringBuilder("{");
        int count = 0;
        for(Map.Entry<String, String> entry : jsonMap.entrySet()){
            json.append("\"").append(entry.getKey()).append("\": ").append(entry.getValue());
            if(++count < jsonMap.size()){
                json.append(", ");
            }
        }
        json.append("}");
        return json.toString();
    }
}

class Person{
    private String name;
    private int age;
    private boolean isEmployed;

    public Person(String name, int age, boolean isEmployed){
        this.name = name;
        this.age = age;
        this.isEmployed = isEmployed;
    }
}

public class JsonRepresentation{
    public static void main(String[] args){
        Person person = new Person("Dhruv", 22, true);
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}