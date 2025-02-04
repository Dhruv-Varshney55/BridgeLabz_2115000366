class Employee{
    static String companyName = "Capgemini";
    private String name;
    private final int id;
    private String designation;
    private static int totalEmployees = 0;

    public Employee(String name, int id, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees(){
		System.out.println();
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayEmployeeDetails(){
        if(this instanceof Employee){
            System.out.println("\nName: " + name);
            System.out.println("ID: " + id);
            System.out.println("Designation: " + designation);
            System.out.println("Company: " + companyName);
        }
    }

    public static void main(String[] args){
        Employee emp1 = new Employee("Dhruv", 366, "Java Developer");
        Employee emp2 = new Employee("Vikas", 1014, "Frontend Developer");
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        displayTotalEmployees();
    }
}