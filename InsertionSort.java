import java.util.Arrays;
public class InsertionSort{
	
	public static void main(String[] args){
        int[] id = {104, 102, 105, 101, 103};
        System.out.println("Unsorted IDs: " + Arrays.toString(id));
        sortEmployeeId(id);
        System.out.println("Sorted IDs: " + Arrays.toString(id));
    }
	
    public static void sortEmployeeId(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
	
}