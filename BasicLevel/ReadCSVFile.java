import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile{
    public static void main(String[] args){
        String file = "Student.csv";
        String line;
        boolean isHeader = true;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((line = br.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] arr = line.split(",");
                if(arr.length == 4){
                    int id = Integer.parseInt(arr[0].trim());
                    String name = arr[1].trim();
                    int age = Integer.parseInt(arr[2].trim());
                    int marks = Integer.parseInt(arr[3].trim());
                    System.out.println("Student ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Marks: " + marks);
                    System.out.println();
                }
            }
        }
		catch(IOException e){
            System.out.println("Error reading the file: " + e.getMessage());
        }
		catch(NumberFormatException e){
            System.out.println("Invalid number format");
        }
    }
}