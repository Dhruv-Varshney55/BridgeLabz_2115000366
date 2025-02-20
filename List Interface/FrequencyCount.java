import java.util.*;
public class FrequencyCount{
	public static void main(String[] args){
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        HashMap<String, Integer> ans = countFrequency(list);
        System.out.println(ans);
    }
	
    public static HashMap<String, Integer> countFrequency(List<String> list){
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : list){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }
}