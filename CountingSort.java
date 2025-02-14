import java.util.Arrays;
public class CountingSort{

	public static void main(String[] args){
        int[] age = {2, 5, 0, 1, 7, 4, 3, 9, 6, 8};
        System.out.println("Unsorted Age: " + Arrays.toString(age));
        sortStudentarr(age);
        System.out.println("Sorted Age: " + Arrays.toString(age));
    }
	
    public static void sortStudentarr(int[] arr){
        int max = 9;
        int min = 0;
        int range = max - min + 1;
        int[] count = new int[range];
        int[] ans = new int[arr.length];
        for(int age : arr){
            count[age - min]++;
        }
        for(int i=1; i<range; i++){
            count[i] += count[i-1];
        }
        for(int i=arr.length-1; i>=0; i--){
            ans[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(ans, 0, arr, 0, arr.length);
    }
    
}