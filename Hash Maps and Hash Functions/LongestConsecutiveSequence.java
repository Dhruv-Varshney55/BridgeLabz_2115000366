import java.util.*;
class LongestConsecutiveSequence{
    public static void main(String[] args){
        int[] arr = {9, 1, 4, 7, 3, 2, 6, 100, 101, 5};
        System.out.println(longestSequence(arr));
    }
	
	public static int longestSequence(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
			set.add(num);
		}
        int maxLen = 0;
        for(int num : nums){
            if(!set.contains(num - 1)){
                int length = 1;
                while(set.contains(num + length)){
					length++;
				}
                maxLen = Math.max(maxLen, length);
            }
        }
        return maxLen;
    }
}