import java.io.*;
public class UserInputFromConsole{
    public static void main(String[] args){
        String file = "Data.txt";
        try(BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            FileWriter w = new FileWriter(file, true)){
            System.out.print("Enter your name: ");
            String name = r.readLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(r.readLine());
            System.out.print("Enter your favorite programming language: ");
            String language = r.readLine();
            w.write("Name: " + name + "\n");
            w.write("Age: " + age + "\n");
            w.write("Favorite Language: " + language + "\n");
            System.out.println("\nData saved successfully in " + file);
        }
		catch(IOException e){
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
		catch(NumberFormatException e){
            System.out.println("Invalid input, Age must be a number.");
        }
    }
}