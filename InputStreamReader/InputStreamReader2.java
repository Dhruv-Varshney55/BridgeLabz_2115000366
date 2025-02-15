import java.io.*;
public class InputStreamReader2{
    public static void main(String[] args){
        String file = "Hello.txt";
        try(
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
        ){
            System.out.println("Enter text (type 'exit' to stop):");
            String input;
            while(true){
                input = br.readLine();
                if("exit".equalsIgnoreCase(input)){
                    break;
                }
                bw.write(input);
                bw.newLine();
            }
            System.out.println("Input has been saved to " + file);
        }
		catch(IOException e){
            e.printStackTrace();
        }
    }
}