import java.util.Arrays;
public class LinearAndBinarySearch{
	public static void main(String[] args){
        int[] arr = {3, 0, -1, 1, 5, 2, 6, 8, 7};
        int missing = firstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);
		
        int target = 6;
        int index = binarySearch(arr, target);
        System.out.println("Target Index: " + index);
    }
	
    public static int firstMissingPositive(int[] nums){
        int n = nums.length;
        for(int i=0; i<n; i++){
            while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0;
		int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
            }
			else if(arr[mid] < target){
                left = mid + 1;
            }
			else{
                right = mid - 1;
            }
        }
        return -1;
    }
}