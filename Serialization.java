import java.io.*;
import java.util.*;
class Employee implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void display(){
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class Serialization{
    private static final String file = "Employee.txt";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        int count = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<count; i++){
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Department: ");
            String department = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            list.add(new Employee(id, name, department, salary));
        }
        serializeEmployees(list);
        List<Employee> retrievedEmployees = deserializeEmployees();
        if(retrievedEmployees != null){
            System.out.println("\nRetrieved Employees:");
            for(Employee emp : retrievedEmployees){
                emp.display();
            }
        }
    }

    private static void serializeEmployees(List<Employee> list){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(list);
            System.out.println("\nEmployees serialized successfully");
        }
		catch (IOException e){
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    private static List<Employee> deserializeEmployees(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<Employee>) ois.readObject();
        }
		catch(IOException | ClassNotFoundException e){
            System.out.println("Error during deserialization: " + e.getMessage());
        }
        return null;
    }
}