import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    int marks;
    String grade;

    public Student(int id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + marks + "," + grade;
    }
}

public class MergeTwoCSVFiles {
    public static void main(String[] args) {
        String file1 = "Student1.csv";
        String file2 = "Student2.csv";
        String output = "MergeStudents.csv";

        Map<Integer, Student> studentMap = new HashMap<>();

        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1))) {
            String line;
            boolean isHeader = true;
            while ((line = reader1.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                studentMap.put(id, new Student(id, name, age, 0, ""));
            }
        } catch (IOException e) {
            System.out.println("Error reading Student1.csv");
            e.printStackTrace();
        }

        try (BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String line;
            boolean isHeader = true;
            while ((line = reader2.readLine()) != null) {
                if (isHeader) {
                    isHeader = false;
                    continue;
                }
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0].trim());
                int marks = Integer.parseInt(data[1].trim());
                String grade = data[2].trim();

                if (studentMap.containsKey(id)) {
                    Student student = studentMap.get(id);
                    student.marks = marks;
                    student.grade = grade;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading Student2.csv");
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            writer.write("ID,Name,Age,Marks,Grade");
            writer.newLine();
            for (Student student : studentMap.values()) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Merged CSV file saved as: " + output);
        } catch (IOException e) {
            System.out.println("Error writing merged_students.csv");
            e.printStackTrace();
        }
    }
}