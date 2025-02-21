import java.io.*;
public class DataStreams{
    public static void main(String[] args){
        String file = "Student.txt";
        writeStudentData(file);
        readStudentData(file);
    }
	
    private static void writeStudentData(String file){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(101);
            dos.writeUTF("Dhruv Varshney");
            dos.writeDouble(8.2);

            dos.writeInt(102);
            dos.writeUTF("Vikas Kumar Singh");
            dos.writeDouble(8.4);

            dos.writeInt(103);
            dos.writeUTF("Rishabh Singh");
            dos.writeDouble(8.3);

            System.out.println("Student data written successfully");
        }
		catch(IOException e){
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
	
    private static void readStudentData(String file){
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            System.out.println("\nStudent Details from File:");
            while(dis.available() > 0){
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        }
		catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}