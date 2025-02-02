import java.util.Scanner;

class Student{
    public int rollNumber;
    protected String name;
    private double CGPA;

    Student(int rollNumber, String name, double CGPA){
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public double getCGPA(){
        return CGPA;
    }

    public void setCGPA(double CGPA){
        this.CGPA = CGPA;
    }

    void displayStudentDetails(){
        System.out.println("\nRoll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}


class PostgraduateStudent extends Student{
	
    private String specialization;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization){
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void displayPostgraduateDetails(){
        displayStudentDetails();
        System.out.println("Specialization: " + specialization);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter CGPA: ");
        double CGPA = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        PostgraduateStudent pg = new PostgraduateStudent(rollNumber, name, CGPA, specialization);
        pg.displayPostgraduateDetails();
        System.out.print("\nEnter new CGPA: ");
        double newCGPA = sc.nextDouble();
        pg.setCGPA(newCGPA);
        System.out.println("\nUpdated Student Details:");
        pg.displayPostgraduateDetails();
    }
}