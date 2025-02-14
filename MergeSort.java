import java.util.Arrays;
public class MergeSort{
	
	public static void main(String[] args){
        int[] book = {400, 1000, 250, 300, 500, 150};
        System.out.println("Unsorted Prices: " + Arrays.toString(book));
        sortBookPrice(book, 0, book.length-1);
        System.out.println("Sorted Prices: " + Arrays.toString(book));
    }
	
	public static void sortBookPrice(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            sortBookPrice(arr, left, mid);
            sortBookPrice(arr, mid + 1, right);
            mergeArray(arr, left, mid, right);
        }
    }
	
    public static void mergeArray(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] num1 = new int[n1];
        int[] num2 = new int[n2];
        System.arraycopy(arr, left, num1, 0, n1);
        System.arraycopy(arr, mid + 1, num2, 0, n2);
        int i = 0, j = 0, k = left;
        while(i<n1 && j<n2){
            if(num1[i] <= num2[j]){
                arr[k] = num1[i];
                i++;
            }
			else{
                arr[k] = num2[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k] = num1[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = num2[j];
            j++;
            k++;
        }
    }
	
}