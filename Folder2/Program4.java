import java.util.Scanner;
public class Program4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long num = sc.nextLong();
        int max = 10;
        int [] arr = new int[max];
        int idx = 0;
        while(num != 0){
            if(idx == max){
                max += 10;
                int [] temp = new int[max];
                for(int i=0; i<arr.length; i++){
                    temp[i] = arr[i];
                }
                arr = temp;
            }
            arr[idx++] = (int) (num % 10);
            num /= 10;
        }
        int largest = 0, secondLargest = 0;
        for(int i=0; i<idx; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            } 
			else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}