import java.util.ArrayList;
import java.util.List;

abstract class CourseType{
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor){
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName(){ 
		return courseName; 
	}
	
    public String getInstructor(){
		return instructor; 
	}

    @Override
    public String toString(){
        return courseName + " (Instructor: " + instructor + ")";
    }
}

class ExamCourse extends CourseType{
    public ExamCourse(String courseName, String instructor){
        super(courseName, instructor);
    }
}

class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseName, String instructor){
        super(courseName, instructor);
    }
}

class ResearchCourse extends CourseType{
    public ResearchCourse(String courseName, String instructor){
        super(courseName, instructor);
    }
}

class Course<T extends CourseType>{
    private T courseType;

    public Course(T courseType){
        this.courseType = courseType;
    }

    public T getCourseType(){ 
		return courseType; 
	}

    @Override
    public String toString(){
        return "Course: " + courseType;
    }
}

class CourseManagement{
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course){
        courses.add(course);
    }

    public void showCourses(){
        for(Course<? extends CourseType> course : courses){
            System.out.println(course);
        }
    }
}

public class UniversityCourseManagementSystem{
    public static void main(String[] args){
        CourseManagement management = new CourseManagement();
        Course<ExamCourse> math = new Course<>(new ExamCourse("Mathematics", "Dr. Pramod Sharma"));
        Course<AssignmentCourse> cs = new Course<>(new AssignmentCourse("Computer Science", "Prof. Vinay Agrawal"));
        Course<ResearchCourse> physics = new Course<>(new ResearchCourse("Chemistry", "Prof. Pankaj Garg"));
        management.addCourse(math);
        management.addCourse(cs);
        management.addCourse(physics);
        management.showCourses();
    }
}