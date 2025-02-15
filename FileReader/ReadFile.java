import java.io.*;
public class ReadFile{
    public static void main(String[] args){
        String file = "Myself.txt";
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
		catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}