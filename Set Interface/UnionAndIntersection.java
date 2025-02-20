import java.util.HashSet;
import java.util.Set;
public class UnionAndIntersection{
    public static Set<Integer> union(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> set = new HashSet<>();
        for(Integer num : s1){
            set.add(num);
        }
        for(Integer num : s2){
            if(!set.contains(num)){
                set.add(num);
            }
        }
        return set;
    }

    public static Set<Integer> intersection(Set<Integer> s1, Set<Integer> s2){
        Set<Integer> set = new HashSet<>();
        for(Integer num : s1){
            for(Integer num2 : s2){
                if(num.equals(num2)){
                    set.add(num);
                    break;
                }
            }
        }
        return set;
    }

    public static void main(String[] args){
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        Set<Integer> s2 = new HashSet<>();
        s2.add(3);
        s2.add(4);
        s2.add(5);
        System.out.println("Union: " + union(s1, s2));
        System.out.println("Intersection: " + intersection(s1, s2));
    }
}