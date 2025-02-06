import java.util.ArrayList;
import java.util.List;

class Course{
    private String name;
    private Professor professor;
    private List<Student> students;

    public Course(String name){
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void assignProfessor(Professor professor){
        this.professor = professor;
        professor.addCourse(this);
    }

    public void enrollStudent(Student student){
        students.add(student);
        student.addCourse(this);
    }

    public void showCourseDetails(){
        System.out.println("\nCourse: " + name);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for(Student student : students){
            System.out.println(student.getName());
        }
    }
}

class Professor{
    private String name;
    private List<Course> courses;

    public Professor(String name){
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

    public void showProfessorDetails(){
        System.out.println("\nProfessor: " + name);
        System.out.println("Teaching Courses:");
        for(Course course : courses){
            System.out.println(course.getName());
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

    public void showStudentDetails(){
        System.out.println("\nStudent: " + name);
        System.out.println("Enrolled Courses:");
        for(Course course : courses){
            System.out.println(course.getName());
        }
    }
}

public class UniversityManagementSystem{
    public static void main(String[] args){
        Professor profDhruv = new Professor("Dr. Dhruv");
        Professor profVikas = new Professor("Dr. Vikas");
        Student rishabh = new Student("Rishabh");
        Student ashwani = new Student("Ashwani");
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");
        math.assignProfessor(profDhruv);
        cs.assignProfessor(profVikas);
        math.enrollStudent(rishabh);
        math.enrollStudent(ashwani);
        cs.enrollStudent(ashwani);
        math.showCourseDetails();
        cs.showCourseDetails();
        profDhruv.showProfessorDetails();
        profVikas.showProfessorDetails();
        rishabh.showStudentDetails();
        ashwani.showStudentDetails();
    }
}