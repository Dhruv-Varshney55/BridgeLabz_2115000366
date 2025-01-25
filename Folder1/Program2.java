import java.util.Scanner;
public class Program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[5]; 
        System.out.println("Enter 5 numbers:");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int n : arr){
            if(n > 0){
                System.out.println("Positive and " + (n%2 == 0 ? "Even" : "Odd"));
            } 
			else if(n < 0){
                System.out.println("Negative");
            }
			else{
                System.out.println("Zero");
            }
        }
        if(arr[0] == arr[4]){
            System.out.println("First and last elements are equal");
        } 
		else if(arr[0] > arr[4]){
            System.out.println("First element is greater than the last");
        } 
		else{
            System.out.println("First element is less than the last");
        }
    }
}