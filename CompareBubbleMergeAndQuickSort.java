import java.util.Arrays;
import java.util.Random;
public class CompareBubbleMergeAndQuickSort{
    public static void main(String[] args){
        int[] dataSize = {1000, 10000, 1000000};
        Random rand = new Random();
        for(int size : dataSize){
            int[] data = randomArray(size);
			
            int[] bubbleArr = Arrays.copyOf(data, data.length);
            long start = System.nanoTime();
            if(size <= 10000){
                bubbleSort(bubbleArr);
                System.out.println("Size: " + size);
                System.out.println("Bubble Sort Time: " + (System.nanoTime() - start) / 1e6 + " ms");
            }
			else{
                System.out.println("Bubble sort unfeasible for size: " + size);
            }

            int[] mergeArr = Arrays.copyOf(data, data.length);
            start = System.nanoTime();
            mergeSort(mergeArr, 0, mergeArr.length - 1);
            System.out.println("Merge Sort Time: " + (System.nanoTime() - start) / 1000000.0f + " ms");

            int[] quickArr = Arrays.copyOf(data, data.length);
            start = System.nanoTime();
            quickSort(quickArr, 0, quickArr.length - 1);
            System.out.println("Quick Sort Time: " + (System.nanoTime() - start) / 1000000.0f + " ms");
            System.out.println();
        }
    }

    public static int[] randomArray(int size){
        Random rand = new Random();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
	
    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        int i = 0, j = 0, k = left;
        while(i<n1 && j<n2){
            if(leftArr[i] <= rightArr[j]){
                arr[k++] = leftArr[i++];
            }
			else{
                arr[k++] = rightArr[j++];
            }
        }
        while(i < n1){
            arr[k++] = leftArr[i++];
        }
        while(j < n2){
            arr[k++] = rightArr[j++];
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; 
        int i = low - 1; 
        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
		
        return i+1;
    }
}