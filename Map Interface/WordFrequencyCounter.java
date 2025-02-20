import java.io.*;
import java.util.*;
public class WordFrequencyCounter{
    public static void main(String[] args){
        String fileName = "Myself.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for(String word : words){
                    if(!word.isEmpty()){
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
		catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println(wordCountMap);
    }
}