import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed{
    String[] value();
}

class User{
    private String role;

    public User(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}

class SecureService{
    
    @RoleAllowed({"ADMIN"})
    public void adminTask(){
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed({"USER", "ADMIN"})
    public void userTask(){
        System.out.println("User task executed successfully!");
    }
}

class AccessControl{
    public static void executeMethodIfAuthorized(User user, Object obj, String methodName){
        try{
            Method method = obj.getClass().getMethod(methodName);
            if(method.isAnnotationPresent(RoleAllowed.class)){
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                String userRole = user.getRole();
                for(String role : roleAllowed.value()){
                    if(role.equals(userRole)){
                        method.invoke(obj);
                        return;
                    }
                }
                System.out.println("Access Denied! User role '" + userRole + "' is not allowed to access " + methodName);
            }
			else{
                method.invoke(obj);
            }
        }
		catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class RoleBasedAccessControl{
    public static void main(String[] args){
        User adminUser = new User("ADMIN");
        User normalUser = new User("USER");
        SecureService service = new SecureService();
        System.out.println("Attempting access as ADMIN:");
        AccessControl.executeMethodIfAuthorized(adminUser, service, "adminTask");
        System.out.println("\nAttempting access as USER:");
        AccessControl.executeMethodIfAuthorized(normalUser, service, "adminTask");
        System.out.println("\nUser trying allowed task:");
        AccessControl.executeMethodIfAuthorized(normalUser, service, "userTask");
    }
}