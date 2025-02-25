import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords{
    public static void main(String[] args){
        String file = "Student.csv";
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int marks = Integer.parseInt(data[2].trim());
                if(marks > 80){
                    System.out.println(line);
                }
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
        }
    }
}