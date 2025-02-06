import java.util.ArrayList;
import java.util.List;

class Faculty{
    private String name;

    public Faculty(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class Department{
    private String name;

    public Department(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}

class University{
    private String name;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String name){
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String deptName){
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty){
        facultyMembers.add(faculty);
    }

    public void showUniversityDetails(){
        System.out.println("\nUniversity: " + name);

        System.out.println("\nDepartments:");
        for(Department dept : departments){
            System.out.println(dept.getName());
        }

        System.out.println("\nFaculty Members:");
        for(Faculty faculty : facultyMembers){
            System.out.println(faculty.getName());
        }
    }

    public void deleteUniversity(){
        System.out.println("\nDeleting University: " + name);
        departments.clear();
    }
}

public class UniversitySystem{
    public static void main(String[] args){
        University myUniversity = new University("GLA University");
        myUniversity.addDepartment("Computer Science");
        myUniversity.addDepartment("Electrical Engineering");
        Faculty prof1 = new Faculty("Prof. Dhruv");
        Faculty prof2 = new Faculty("Prof. Vikas");
        myUniversity.addFaculty(prof1);
        myUniversity.addFaculty(prof2);
        myUniversity.showUniversityDetails();
        myUniversity.deleteUniversity();
        myUniversity.showUniversityDetails();
    }
}