import java.io.*;
import java.util.*;

class Student{
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Student{ ID=" + id + ", Name='" + name + "', Marks=" + marks + " }";
    }
}

public class CSVToJavaObjects{
    public static void main(String[] args){
        String file = "students.csv";
        List<Student> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isHeader = true;
            while((line = reader.readLine()) != null) {
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int marks = Integer.parseInt(data[2].trim());
                list.add(new Student(id, name, marks));
            }
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
        for(Student student : list) {
            System.out.println(student);
        }
    }
}