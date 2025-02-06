import java.util.ArrayList;
import java.util.List;

class Employee{
    private String name;

    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Department{
    private String name;
    private List<Employee> employees;

    public Department(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName){
        employees.add(new Employee(employeeName));
    }

    public void showEmployees(){
        System.out.println("Department: " + name);
        for (Employee emp : employees) {
            System.out.println(emp.getName());
        }
    }
	
	public String getName(){
        return name;
    }
}

class Company{
    private String name;
    private List<Department> departments;

    public Company(String name){
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName){
        departments.add(new Department(departmentName));
    }

    public Department getDepartment(String departmentName){
        for(Department dept : departments){
            if(dept.getName().equals(departmentName)){
                return dept;
            }
        }
        return null;
    }

    public void showCompanyStructure(){
        System.out.println("\nCompany: " + name);
        for (Department dept : departments){
            dept.showEmployees();
        }
    }

    public void deleteCompany(){
        System.out.println("\nDeleting Company: " + name);
        departments.clear();
    }
}

public class CompanySystem{
    public static void main(String[] args){
        Company myCompany = new Company("Capgemini");
        myCompany.addDepartment("Engineering");
        myCompany.addDepartment("HR");
        Department engineering = myCompany.getDepartment("Engineering");
        if(engineering != null){
            engineering.addEmployee("Dhruv");
            engineering.addEmployee("Vikas");
        }
        Department hr = myCompany.getDepartment("HR");
        if(hr != null){
            hr.addEmployee("Rishabh");
        }
        myCompany.showCompanyStructure();
        myCompany.deleteCompany();
        myCompany.showCompanyStructure();
    }
}