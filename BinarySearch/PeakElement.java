public class PeakElement{
	public static void main(String[] args){
        int[] arr = {5, 3, 7, 1, 8, 6}; 
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }
	
    public static int findPeakElement(int[] arr){
        int left = 0;
		int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid + 1]){
                right = mid;
            }
			else{
                left = mid + 1;
            }
        }
        return left;
    }
}