import java.util.Arrays;
public class BubbleSort{
	
	public static void main(String[] args){
        int[] marks = {90, 75, 83, 72, 79, 85, 99, 67};
        System.out.println("Unsorted Marks: " + Arrays.toString(marks));
		sortStudentMarks(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }
	
    public static void sortStudentMarks(int[] arr){
        int n = arr.length;
        boolean ans;
        for(int i=0; i<n-1; i++){
            ans = false;
            for(int j=0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    ans = true;
                }
            }
            if(!ans){
				break;
			}
        }
    }
	
}