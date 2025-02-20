import java.util.HashSet;
import java.util.Set;
public class EqualSets{
	public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Integer> s2 = new HashSet<>();
        s2.add(3);
        s2.add(2);
        s2.add(1);
        System.out.println("Are sets equal? " + areSetsEqual(s1, s2));
    }
	
    public static boolean areSetsEqual(Set<Integer> s1, Set<Integer> s2){
        if(s1.size() != s2.size()){
            return false;
        }
        for(Integer val : s1){
            if(!s2.contains(val)){
                return false;
            }
        }
        return true;
    }   
}