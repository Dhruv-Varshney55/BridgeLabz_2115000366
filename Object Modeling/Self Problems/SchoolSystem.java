import java.util.ArrayList;
import java.util.List;

class Course{
    private String name;
    private List<Student> enrolledStudents;

    public Course(String name){
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void enrollStudent(Student student){
        if(!enrolledStudents.contains(student)){
            enrolledStudents.add(student);
            student.addCourse(this);
        }
    }

    public void showEnrolledStudents(){
        System.out.println("\nCourse: " + name + " - Enrolled Students:");
        for(Student student : enrolledStudents){
            System.out.println(student.getName());
        }
    }
}

class Student{
    private String name;
    private List<Course> courses;

    public Student(String name){
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addCourse(Course course){
        if(!courses.contains(course)){
            courses.add(course);
        }
    }

    public void viewEnrolledCourses(){
		System.out.println();
        System.out.println(name + " is enrolled in:");
        for(Course course : courses){
            System.out.println(course.getName());
        }
    }
}

class School{
    private String name;
    private List<Student> students;

    public School(String name){
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void showStudents(){
        System.out.println("\nStudents at " + name + ":");
        for(Student student : students){
            System.out.println(student.getName());
        }
    }
}

public class SchoolSystem{
    public static void main(String[] args){
        School mySchool = new School("RLVM School");
        Student dhruv = new Student("Dhruv");
        Student vikas = new Student("Vikas");
        mySchool.addStudent(dhruv);
        mySchool.addStudent(vikas);
        Course math = new Course("Mathematics");
        Course science = new Course("Science");
        math.enrollStudent(dhruv);
        math.enrollStudent(vikas);
        science.enrollStudent(dhruv);
        mySchool.showStudents();
        math.showEnrolledStudents();
        science.showEnrolledStudents();
        dhruv.viewEnrolledCourses();
        vikas.viewEnrolledCourses();
    }
}