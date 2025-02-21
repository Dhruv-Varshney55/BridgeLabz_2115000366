import java.io.*;
import java.util.*;
public class CountWords{
    public static void main(String[] args) {
        String file = "Error.txt";
        Map<String, Integer> map = new HashMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while((line = reader.readLine()) != null){
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for(String word : words){
                    if(!word.isEmpty()){
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
		catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
		
        int totalWords = map.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("Total words in file: " + totalWords);
		
        System.out.println("Top 5 most frequently occurring words:");
        for (int i = 0; i < Math.min(5, list.size()); i++){
            System.out.println(list.get(i).getKey() + " - " + list.get(i).getValue());
        }
    }
}
