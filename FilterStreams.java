import java.io.*;
public class FilterStreams{
    public static void main(String[] args){
        String upperFile = "Upper.txt";
        String lowerFile = "Lower.txt";
        try(
            FileReader fileReader = new FileReader(upperFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(lowerFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ){
            String line;
            while((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line.toLowerCase());
                bufferedWriter.newLine();
            }
            System.out.println("Conversion completed, Check '" + lowerFile + "'");
        }
		catch(IOException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}