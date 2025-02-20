import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference{
	public static Set<Integer> symmetricDifference(Set<Integer> s1, Set<Integer> s2){
		Set<Integer> set1 = new HashSet<>(s1);
		Set<Integer> set2 = new HashSet<>(s2);
		set1.removeAll(s2);
		set2.removeAll(s1);
		set1.addAll(set2);
		return set1;
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
		System.out.println("Symmetric Difference: " + symmetricDifference(s1, s2));
	}
}