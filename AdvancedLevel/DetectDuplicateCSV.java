import java.io.*;
import java.util.*;

public class DetectDuplicateCSV{
    public static void main(String[] args){
        String file = "Employees.csv";
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null) {
                if(isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                String id = data[0].trim();
                if(map.containsKey(id)) {
                    set.add(line);
                }
				else{
                    map.put(id, line);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
        if(set.isEmpty()) {
            System.out.println("No duplicate records found.");
        }
		else {
            System.out.println("Duplicate records found:");
            for (String record : set) {
                System.out.println(record);
            }
        }
    }
}