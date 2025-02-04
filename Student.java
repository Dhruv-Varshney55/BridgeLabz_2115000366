class Student{
    static String universityName = "GLA University";
    private String name;
    private final int rollNumber;
    private String grade;
    private static int totalStudents = 0;

    public Student(String name, int rollNumber, String grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents(){
		System.out.println();
        System.out.println("Total Students: " + totalStudents);
    }

    void displayStudentDetails(){
        if(this instanceof Student){
            System.out.println("\nName: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
        }
    }

    public static void main(String[] args){
        Student s1 = new Student("Dhruv", 366, "A+");
        Student s2 = new Student("Vikas", 455, "A");
		Student s3 = new Student("Rishabh", 345, "C");
        Student s4 = new Student("Aman", 234, "B");
        Student s5 = new Student("Ashwani", 432, "B+");
        s1.displayStudentDetails();
        s2.displayStudentDetails();
        s3.displayStudentDetails();
        s4.displayStudentDetails();
        s5.displayStudentDetails();
        displayTotalStudents();
    }
}