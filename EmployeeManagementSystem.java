import java.util.ArrayList;
import java.util.List;

abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary){
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public String getName(){
        return name;
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary){
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails(){
		System.out.println();
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: Rs." + baseSalary);
        System.out.println("Total Salary: Rs." + calculateSalary());
    }
}

interface Department{
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department{
    private double monthlySalary;
    private String department;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double monthlySalary){
        super(employeeId, name, baseSalary);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

    @Override
    public void assignDepartment(String department){
        this.department = department;
    }

    @Override
    public String getDepartmentDetails(){
        return "Department: " + department;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println(getDepartmentDetails());
    }
}

class PartTimeEmployee extends Employee implements Department{
    private int hoursWorked;
    private double hourlyRate;
    private String department;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate){
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }

    @Override
    public void assignDepartment(String department){
        this.department = department;
    }

    @Override
    public String getDepartmentDetails(){
        return "Department: " + department;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: Rs." + hourlyRate);
        System.out.println(getDepartmentDetails());
    }
}

public class EmployeeManagementSystem{
    public static void main(String[] args){
        List<Employee> employees = new ArrayList<>();
        FullTimeEmployee e1 = new FullTimeEmployee(101, "Dhruv", 80000, 100000);
        e1.assignDepartment("IT");
        PartTimeEmployee e2 = new PartTimeEmployee(102, "Vikas", 50000, 80, 100);
        e2.assignDepartment("HR");
        employees.add(e1);
        employees.add(e2);
        for(Employee e : employees){
            e.displayDetails();
        }
    }
}