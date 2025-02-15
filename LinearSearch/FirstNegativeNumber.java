public class FirstNegativeNumber{
	public static void main(String[] args){
        int[] arr = {32, 21, -42, 2, 23, -5};
        System.out.println("Index of first negative number: " + findFirstNegative(arr));
    }
	
    public static int findFirstNegative(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0){
                return i;
            }
        }
        return -1;
    }   
}