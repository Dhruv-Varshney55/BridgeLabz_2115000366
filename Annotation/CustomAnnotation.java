import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority();
    String assignedTo();
}

class TaskManager{
    @TaskInfo(priority = "High", assignedTo = "Dhruv")
    public void completeTask(){
        System.out.println("Task completed");
    }
}

public class CustomAnnotation{
    public static void main(String[] args) throws Exception{
        Method m = TaskManager.class.getMethod("completeTask");
        if(m.isAnnotationPresent(TaskInfo.class)){
            TaskInfo taskInfo = m.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + taskInfo.priority());
            System.out.println("Assigned To: " + taskInfo.assignedTo());
        }
    }
}