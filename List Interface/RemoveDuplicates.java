import java.util.*;
public class RemoveDuplicates{
	public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        System.out.println("Original List: " + list);
        removeDuplicates(list);
        System.out.println("Removing Duplicates: " + list);
    }
	
    public static void removeDuplicates(ArrayList<Integer> list){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ll = new ArrayList<>();
        for(Integer num : list){
            if(!set.contains(num)){
                set.add(num);
                ll.add(num);
            }
        }
        list.clear();
        list.addAll(ll);
    }
}