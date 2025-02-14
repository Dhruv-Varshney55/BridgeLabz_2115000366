import java.util.Arrays;
public class SelectionSort{

	public static void main(String[] args){
        int[] scores = {85, 92, 78, 65, 89, 70, 95, 88};
        System.out.println("Unsorted Scores: " + Arrays.toString(scores));
        sortExamsScore(scores);
        System.out.println("Sorted Scores: " + Arrays.toString(scores));
    }
	
    public static void sortExamsScore(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
	
}