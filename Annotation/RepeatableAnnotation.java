import java.lang.annotation.*;
import java.lang.reflect.Method;

@Repeatable(BugReports.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReport{
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

class BugTracker{
    @BugReport(description = "Null pointer exception in edge cases")
    @BugReport(description = "Performance issue when handling large inputs")
    public void processTask(){
        System.out.println("Processing task...");
    }
}

public class RepeatableAnnotation{
    public static void main(String[] args) throws Exception{
        Method m = BugTracker.class.getMethod("processTask");
        if(m.isAnnotationPresent(BugReports.class)){
            BugReports bugReports = m.getAnnotation(BugReports.class);
            for(BugReport bug : bugReports.value()){
                System.out.println("Bug Report: " + bug.description());
            }
        }
    }
}