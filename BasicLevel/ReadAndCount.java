import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCount{
    public static void main(String[] args){
        String file = "Employee.csv";
        int recordCount = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                recordCount++;
            }
            System.out.println("Total number of records: " + recordCount);
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
        }
    }
}