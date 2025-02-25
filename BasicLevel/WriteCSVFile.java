import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile{
    public static void main(String[] args){
        String file = "Employee.csv";
        try(FileWriter writer = new FileWriter(file)){
            writer.append("ID,Name,Department,Salary\n");
            writer.append("101,Dhruv Varshney,IT,85000\n");
            writer.append("102,Vikas Kumar Singh,ME,60000\n");
            writer.append("103,Rishabh Singh,HR,50000\n");
            System.out.println("CSV file created successfully");
        }
		catch(IOException e){
            System.out.println("Error writing the file");
            e.printStackTrace();
        }
    }
}