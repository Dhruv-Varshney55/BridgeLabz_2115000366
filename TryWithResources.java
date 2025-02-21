import java.io.*;
public class TryWithResources{
    public static void main(String[] args){
        String file = "Myself.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String firstLine = br.readLine();
            if(firstLine != null){
                System.out.println("First line: " + firstLine);
            }
			else{
                System.out.println("File is empty");
            }
        }
		catch(IOException e){
            System.out.println("Error reading file");
        }
    }
}