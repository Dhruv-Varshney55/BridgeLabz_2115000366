import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks{
    
    @Todo(task = "Implement user authentication", assignedTo = "Dhruv", priority = "HIGH")
    public void authenticateUser(){
        System.out.println("Authentication logic pending...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Vikas")
    public void optimizeDatabase(){
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Improve UI responsiveness", assignedTo = "Rishabh", priority = "LOW")
    public void improveUI(){
        System.out.println("UI improvements pending...");
    }

    public void completedTask(){
        System.out.println("This task is completed");
    }
}

public class PendingTasks{
    public static void main(String[] args){
        Class<ProjectTasks> obj = ProjectTasks.class;
        for(Method method : obj.getDeclaredMethods()){
            if(method.isAnnotationPresent(Todo.class)){
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}