import java.io.*;
public class CountOccurences{
    public static void main(String[] args){
        String file = "Myself.txt";
        String target = "Far";
        int count = wordOccurrences(file, target);
        System.out.println("The word \"" + target + "\" appears " + count + " times in the file");
    }

    public static int wordOccurrences(String file, String target){
        int count = 0;
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            String line;
            while((line = br.readLine()) != null){
                String[] words = line.split("\\s+");
                for(String word : words){
                    if(word.equalsIgnoreCase(target)){
                        count++;
                    }
                }
            }
        }
		catch(IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return count;
    }
}