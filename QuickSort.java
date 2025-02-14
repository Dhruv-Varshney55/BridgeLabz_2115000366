import java.util.Arrays;
public class QuickSort{
	
	public static void main(String[] args){
        int[] product = {43, 64, 23, 86, 65, 89, 32};
        System.out.println("Unsorted prices: " + Arrays.toString(product));
        sortproduct(product, 0, product.length - 1);
        System.out.println("Sorted prices: " + Arrays.toString(product));
    }
	
    public static void sortproduct(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            sortproduct(arr, low, pivotIndex - 1);
            sortproduct(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
}