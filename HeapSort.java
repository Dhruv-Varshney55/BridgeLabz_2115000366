import java.util.Arrays;
public class HeapSort{
    
	public static void main(String[] args){
        int[] salary = {65000, 85000, 50000, 100000, 60000, 75000, 45000, 90000};
        System.out.println("Unsorted salary: " + Arrays.toString(salary));
        sortSalary(salary);
        System.out.println("Sorted salary: " + Arrays.toString(salary));
    }
	
	public static void sortSalary(int[] arr){
        int n = arr.length;
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
	
    public static void heapify(int[] arr, int n, int i){
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[max]){
            max = left;
        }
        if(right < n && arr[right] > arr[max]){
            max = right;
        }
        if(max != i){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
    }
	
}