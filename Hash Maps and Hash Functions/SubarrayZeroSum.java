import java.util.*;
public class SubarrayZeroSum{
    static ArrayList<int[]> findSubarrays(int[] arr){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> initialArrayList = new ArrayList<>();
        initialArrayList.add(-1);
        map.put(0, initialArrayList);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                for(int start : map.get(sum)){
                    int[] subarray = new int[i - start];
                    for(int j=start+1, k=0; j<=i; j++, k++){
                        subarray[k] = arr[j];
                    }
                    result.add(subarray);
                }
            }
            if(!map.containsKey(sum)){
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args){
		int[] arr = {1, 2, -3, 3, 1, -4, 2, 2, -2, 2, -2};
        ArrayList<int[]> subarrays = findSubarrays(arr);
        for(int[] sub : subarrays){
            System.out.print("[");
            for(int i=0; i<sub.length; i++){
                System.out.print(sub[i]);
                if(i < sub.length - 1){
					System.out.print(", ");
				}
            }
            System.out.println("]");
        }
    }
}