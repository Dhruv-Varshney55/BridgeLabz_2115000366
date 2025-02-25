import java.io.*;
import java.util.*;

public class SortCSVBySalary{
    public static void main(String[] args){
        String file = "Employees.csv";
        List<String[]> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            String header = reader.readLine();
            while((line = reader.readLine()) != null){
                list.add(line.split(","));
            }
            list.sort((a, b) -> Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim())));
            System.out.println(header);
            for(int i=0; i<Math.min(5, list.size()); i++){
                System.out.println(String.join(",", list.get(i)));
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
        }
    }
}