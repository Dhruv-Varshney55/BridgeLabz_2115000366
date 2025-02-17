import java.util.Arrays;
import java.util.Random;
public class CompareLinearAndBinarySearch{
    public static void main(String[] args){
        int[] arrSize = {1000, 10000, 1000000};
        Random rand = new Random();
        for(int size : arrSize){
            int[] arr = randomArray(size);
            int target = arr[rand.nextInt(size)];

            long start = System.nanoTime();
            int linearResult = linearSearch(arr, target);
            long linearTime = System.nanoTime() - start;

            Arrays.sort(arr);
            start = System.nanoTime();
            int binaryResult = binarySearch(arr, target);
            long binaryTime = System.nanoTime() - start;

            System.out.println("Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1000000.0f + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1000000.0f + " ms");
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

    public static int linearSearch(int[] arr, int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target){
        int left = 0;
		int right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                return mid;
			}
            if(arr[mid] < target){
                left = mid + 1;
			}
            else{
                right = mid - 1;
			}
        }
        return -1;
    }
}