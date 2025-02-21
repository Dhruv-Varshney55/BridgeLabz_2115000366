import java.io.*;
public class ReadLargeFile{
    public static void main(String[] args){
        String file = "Error.txt";
        String word = "error";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine()) != null){
                if(line.toLowerCase().contains(word)){
                    System.out.println(line);
                }
            }
        }
		catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}