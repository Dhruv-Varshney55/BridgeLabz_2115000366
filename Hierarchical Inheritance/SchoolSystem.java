class Person{
    protected String name;
    protected int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void displayRole(){
        System.out.println("General Person in the School System");
    }
}

class Teacher extends Person{
    private String subject;

    public Teacher(String name, int age, String subject){
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole(){
        System.out.println("Role: Teacher");
        System.out.println("Teaches: " + subject);
    }
}

class Student extends Person{
    private int grade;

    public Student(String name, int age, int grade){
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole(){
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

class Staff extends Person{
    private String department;

    public Staff(String name, int age, String department){
        super(name, age);
        this.department = department;
    }

    @Override
    public void displayRole(){
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem{
    public static void main(String[] args){
        Teacher teacher = new Teacher("Mr. Pankaj", 40, "Mathematics");
        teacher.displayInfo();
        teacher.displayRole();
        System.out.println("**************************");
        Student student = new Student("Dhruv Varshney", 15, 10);
        student.displayInfo();
        student.displayRole();
		System.out.println("**************************");
        Staff staff = new Staff("Mr. Jitendra", 45, "Administration");
        staff.displayInfo();
        staff.displayRole();
    }
}