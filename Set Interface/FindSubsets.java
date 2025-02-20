import java.util.*;
public class FindSubsets{
    public static boolean isSubset(Set<Integer> s1, Set<Integer> s2){
        for(Integer num : s1){  
            boolean temp = false;
            for(Integer num2 : s2){  
                if(num.equals(num2)){  
                    temp = true;
                    break;  
                }
            }
            if(!temp){ 
                return false;  
            }
        }
        return true;  
    }

    public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        s1.add(2);
        s1.add(3);
        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(4);
        System.out.println("Is s1 a subset of s2? " + isSubset(s1, s2));
    }
}