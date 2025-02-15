public class FirstAndLastOccurrence{
	public static void main(String[] args){
        int[] arr = {3, 6, 7, 8, 8, 8, 9}; 
        int target = 8;
        int first = findFirstOccurrence(arr, target);
        int last = findLastOccurrence(arr, target);
        System.out.println("First Occurrence: " + first);
        System.out.println("Last Occurrence: " + last);
    }
	
    public static int findFirstOccurrence(int[] arr, int target){
        int left = 0;
		int right = arr.length - 1;
        int	first = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                first = mid; 
                right = mid - 1;
            }
			else if(arr[mid] < target){
                left = mid + 1;
            }
			else{
                right = mid - 1;
            }
        }
        return first;
    }

    public static int findLastOccurrence(int[] arr, int target){
        int left = 0;
		int right = arr.length - 1;
		int last = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                last = mid;  
                left = mid + 1;
            }
			else if(arr[mid] < target){
                left = mid + 1;
            }
			else{
                right = mid - 1;
            }
        }
        return last;
    }
}