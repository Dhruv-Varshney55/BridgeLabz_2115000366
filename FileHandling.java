import java.io.*;
public class FileHandling{
    public static void main(String[] args){
        String file = "Myself.txt";
        String filecopy = "MyselfCopy.txt";
        try(FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(filecopy)){
            int byteData;
            while((byteData = fis.read()) != -1){
                fos.write(byteData);
            }
            System.out.println("File copied successfully");
        }
		catch(FileNotFoundException e){
            System.out.println("Error: Source file does not exist");
        }
		catch(IOException e){
            System.out.println("An error occurred while reading or writing the file");
            e.printStackTrace();
        }
    }
}