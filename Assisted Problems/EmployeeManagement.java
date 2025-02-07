class Employee{
    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails(){
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: Rs." + salary);
    }
}

class Manager extends Employee{
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: " + teamSize);
    }
}

class Developer extends Employee{
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: " + programmingLanguage);
    }
}

class Intern extends Employee{
    private int duration;
	
    public Intern(String name, int id, double salary, int duration){
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Intern, Duration: " + duration + " months");
    }
}

public class EmployeeManagement{
    public static void main(String[] args){
        Employee manager = new Manager("Dhruv Varshney", 366, 100000, 10);
        Employee developer = new Developer("Vikar Kumar Singh", 1014, 80000, "Java");
        Employee intern = new Intern("Rishabh Singh", 754, 25000, 12);
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}