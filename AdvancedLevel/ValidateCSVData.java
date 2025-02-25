import java.io.*;
import java.util.regex.*;

public class ValidateCSVData{
    public static void main(String[] args){
        String file = "Employees.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null) {
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                if(data.length < 5){
                    System.out.println("Invalid row (missing fields): " + line);
                    continue;
                }
                String email = data[3].trim();
                String phone = data[4].trim();
                if(!emailPattern.matcher(email).matches()){
                    System.out.println("Invalid email: " + email + " in row: " + line);
                }
                if(!phonePattern.matcher(phone).matches()){
                    System.out.println("Invalid phone number: " + phone + " in row: " + line);
                }
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file");
            e.printStackTrace();
        }
    }
}