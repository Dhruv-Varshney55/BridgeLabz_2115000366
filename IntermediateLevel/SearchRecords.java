import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchRecords{
    public static void main(String[] args){
        String file = "Employees.csv";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine().trim();
        boolean found = false;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null) {
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                String name = data[1].trim();
                String department = data[2].trim();
                String salary = data[3].trim();
                if(name.equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Employee not found");
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
        }
    }
}