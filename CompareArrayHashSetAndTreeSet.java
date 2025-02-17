import java.util.*;
public class CompareArrayHashSetAndTreeSet{
    public static void main(String[] args){
        int[] dataSize = {1000, 100000, 1000000};
        for(int n : dataSize){
            System.out.println("Size: " + n);
            ArrayList<Integer> list = generatelist(n);

			// Searching for the middle element for all sizes
			
            long start = System.nanoTime();
            arraySearch(list, n / 2);
            long arrayTime = System.nanoTime() - start;
            System.out.println("Array Search Time: " + (arrayTime / 1000000.0f) + " ms");

            HashSet<Integer> hashSet = new HashSet<>(list);
            start = System.nanoTime();
            hashSetSearch(hashSet, n / 2);
            long hashSetTime = System.nanoTime() - start;
            System.out.println("HashSet Search Time: " + (hashSetTime / 1000000.0f) + " ms");

            TreeSet<Integer> treeSet = new TreeSet<>(list);
            start = System.nanoTime();
            treeSetSearch(treeSet, n / 2);
            long treeSetTime = System.nanoTime() - start;
            System.out.println("TreeSet Search Time: " + (treeSetTime / 1000000.0f) + " ms");
            System.out.println();
        }
    }

    public static ArrayList<Integer> generatelist(int n){
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=1; i<=n; i++){
            list.add(i);
        }
        return list;
    }

    public static void arraySearch(ArrayList<Integer> list, int target){
        for(int num : list){
            if(num == target){
                return;
            }
        }
    }

    public static void hashSetSearch(HashSet<Integer> hashSet, int target){
        if(hashSet.contains(target)){
            return;
        }
    }

    public static void treeSetSearch(TreeSet<Integer> treeSet, int target){
        if(treeSet.contains(target)){
            return;
        }
    }
}