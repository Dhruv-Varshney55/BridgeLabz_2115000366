import java.util.*;
public class TwoSum{
	public static void main(String[] args){
        int[] arr = {1, 8, 2, 15};
        int target = 10;
        System.out.println(Arrays.toString(findTwoSum(arr, target)));
    }
    public static int[] findTwoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
				return new int[]{map.get(target - nums[i]), i};
			}
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}