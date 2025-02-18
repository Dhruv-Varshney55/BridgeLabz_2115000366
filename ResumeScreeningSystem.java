import java.util.ArrayList;
import java.util.List;

abstract class JobRole{
    String name;

    public JobRole(String name){
        this.name = name;
    }

    abstract void displayJobInfo();
}

class SoftwareEngineer extends JobRole{
    public SoftwareEngineer(){
        super("Software Engineer");
    }

    @Override
    void displayJobInfo(){
        System.out.println("Job Role: " + name);
        System.out.println("Skills required: Java, Python, Algorithms, Data Structures");
    }
}

class DataScientist extends JobRole{
    public DataScientist(){
        super("Data Scientist");
    }

    @Override
    void displayJobInfo(){
        System.out.println("Job Role: " + name);
        System.out.println("Skills required: Python, Machine Learning, Data Analysis");
    }
}

class ProductManager extends JobRole{
    public ProductManager(){
        super("Product Manager");
    }

    @Override
    void displayJobInfo(){
        System.out.println("Job Role: " + name);
        System.out.println("Skills required: Product Strategy, Communication, Market Analysis");
    }
}

class Resume<T extends JobRole>{
    private T jobRole;

    public Resume(T jobRole){
        this.jobRole = jobRole;
    }

    public void processResume(){
		System.out.println();
        System.out.println("Processing resume for the role of " + jobRole.name);
        jobRole.displayJobInfo();
    }
}

class ResumeScreening{
    public static void processResumes(List<? extends JobRole> jobRoles){
        for(JobRole role : jobRoles){
			System.out.println();
            System.out.println("Screening resume for: " + role.name);
            role.displayJobInfo();
        }
    }
}

public class ResumeScreeningSystem{
    public static void main(String[] args){
        SoftwareEngineer se = new SoftwareEngineer();
        DataScientist ds = new DataScientist();
        ProductManager pm = new ProductManager();

        Resume<SoftwareEngineer> softwareEngineerResume = new Resume<>(se);
        Resume<DataScientist> dataScientistResume = new Resume<>(ds);
        Resume<ProductManager> productManagerResume = new Resume<>(pm);

        softwareEngineerResume.processResume();
        dataScientistResume.processResume();
        productManagerResume.processResume();

        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(se);
        jobRoles.add(ds);
        jobRoles.add(pm);

		System.out.println();
        System.out.println("\nProcessing resumes using wildcard method:");
        ResumeScreening.processResumes(jobRoles);
    }
}