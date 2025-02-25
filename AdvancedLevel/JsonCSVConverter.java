import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonCSVConverter {
    
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            reader.close();

            JSONArray jsonArray = new JSONArray(jsonString.toString());
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            
            JSONObject firstObject = jsonArray.getJSONObject(0);
            for (String key : firstObject.keySet()) {
                writer.write(key + ",");
            }
            writer.newLine();
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                for (String key : obj.keySet()) {
                    writer.write(obj.get(key) + ",");
                }
                writer.newLine();
            }

            writer.close();
            System.out.println("CSV file created: " + csvFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");
            
            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], data[i]);
                }
                jsonArray.put(obj);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile));
            writer.write(jsonArray.toString(4));
            writer.close();
            System.out.println("JSON file created: " + jsonFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonFile = "Students.json";
        String csvFile = "students.csv";
        String newJsonFile = "converted_students.json";

        jsonToCsv(jsonFile, csvFile);
        csvToJson(csvFile, newJsonFile);
    }
}