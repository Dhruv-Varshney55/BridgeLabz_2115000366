public class SearchValue{
	public static void main(String[] args){
        int[][] arr = {
            {11, 14, 16, 18},
            {19, 23, 26, 30},
            {33, 38, 45, 50}
        };
        int target = 45;
        System.out.println("Target found: " + findValueInarr(arr, target));
    }
	
    public static boolean findValueInarr(int[][] arr, int target){
        if(arr==null || arr.length==0 || arr[0].length==0){
            return false;
        }
        int row = arr.length;
		int col = arr[0].length;
        int left = 0;
		int right = row * col - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int midEle = arr[mid / col][mid % col]; 
            if(midEle == target){
                return true;
            }
			else if(midEle < target){
                left = mid + 1;
            }
			else{
                right = mid - 1;
            }
        }
        return false;
    }
}