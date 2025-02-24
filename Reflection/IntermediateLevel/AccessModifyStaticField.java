import java.lang.reflect.Field;

class Configuration{
    private static String API_KEY = "DEFAULT_API_KEY";

    public static String getApiKey(){
        return API_KEY;
    }
}

public class AccessModifyStaticField{
    public static void main(String[] args){
        try{
            Class<?> clazz = Configuration.class;
            Field field = clazz.getDeclaredField("API_KEY");

            field.setAccessible(true);
            field.set(null, "NEW_API_KEY");

            System.out.println("Modified API_KEY: " + Configuration.getApiKey());
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}