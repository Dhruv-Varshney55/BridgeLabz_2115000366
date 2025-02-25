import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModifyCSV{
    public static void main(String[] args){
        String file = "Employees.csv";
        String output = "Update_Employees.csv";
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null) {
                if(isHeader){
                    list.add(line);
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                String department = data[2].trim();
                double salary = Double.parseDouble(data[3].trim());
                if(department.equalsIgnoreCase("IT")){
                    salary *= 1.10;
                    data[3] = String.format("%.2f", salary);
                }
                list.add(String.join(",", data));
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
            return;
        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for(String record : list){
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Updated");
        }
		catch(IOException e){
            System.out.println("An error occurred while writing the CSV file");
            e.printStackTrace();
        }
    }
}