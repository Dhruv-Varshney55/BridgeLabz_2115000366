import java.util.*;
public class RotateList{
	public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        System.out.println("Original List: " + list);
        rotateElements(list, k);
        System.out.println("Rotated List: " + list);
    }
	
    public static void rotateElements(ArrayList<Integer> list, int k){
        int n = list.size();
        if(n==0 || k%n==0){
			return;
		}
        k = k % n;
        ArrayList<Integer> ll = new ArrayList<>();
        for(int i=k; i<n; i++){
            ll.add(list.get(i));
        }
        for(int i=0; i<k; i++){
            ll.add(list.get(i));
        }
        for(int i=0; i<n; i++){
            list.set(i, ll.get(i));
        }
    }   
}