class Course{
    protected String courseName;
    protected int duration;

    public Course(String courseName, int duration){
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayCourseInfo(){
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course{
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded){
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayCourseInfo(){
        super.displayCourseInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse{
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount){
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFinalFee(){
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayCourseInfo(){
        super.displayCourseInfo();
        System.out.println("Fee: Rs." + fee);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Final Fee: Rs." + getFinalFee());
    }
}

public class CourseHierarchy{
    public static void main(String[] args){
        Course course = new Course("Introduction to Java", 6);
        course.displayCourseInfo();
        OnlineCourse onlineCourse = new OnlineCourse("Web Development", 8, "Udemy", true);
        onlineCourse.displayCourseInfo();
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Machine Learning", 12, "Coursera", false, 500, 20);
        paidCourse.displayCourseInfo();
    }
}