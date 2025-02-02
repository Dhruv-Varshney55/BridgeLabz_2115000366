import java.util.Scanner;

class Employee{

    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary){
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        if(salary > 0){
            this.salary = salary;
            System.out.println("Salary updated to Rs." + salary);
        }
		else{
            System.out.println("Invalid salary amount");
        }
    }

    void displayEmployeeDetails(){
        System.out.println("\nEmployee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs." + salary);
    }
}


class Manager extends Employee{

    private String teamName;

    Manager(int employeeID, String department, double salary, String teamName){
        super(employeeID, department, salary);
        this.teamName = teamName;
    }

    void displayManagerDetails(){
        displayEmployeeDetails();
        System.out.println("Managing Team: " + teamName);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        int employeeID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Salary: Rs.");
        double salary = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Team Name: ");
        String teamName = sc.nextLine();
        Manager manager = new Manager(employeeID, department, salary, teamName);
        manager.displayManagerDetails();
        System.out.print("\nEnter new salary to update: Rs.");
        double newSalary = sc.nextDouble();
        manager.setSalary(newSalary);
        manager.displayManagerDetails();
    }
}