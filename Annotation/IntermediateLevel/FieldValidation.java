import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}

class User{
    
    @MaxLength(10)
    private String username;

    public User(String username){
        this.username = username;
        validateFields();
    }

    private void validateFields(){
        for(Field field : this.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(MaxLength.class)){
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                try{
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(this);
                    if(fieldValue.length() > maxLength.value()){
                        throw new IllegalArgumentException(
                            "Error: " + field.getName() + " exceeds max length of " + maxLength.value()
                        );
                    }
                }
				catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUsername(){
        return username;
    }
}

public class FieldValidation{
    public static void main(String[] args){
        try{
            User user1 = new User("Dhruv");
            System.out.println("Valid Username: " + user1.getUsername());

            User user2 = new User("DhruvVarshney");
            System.out.println("Valid Username: " + user2.getUsername());
        }
		catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}