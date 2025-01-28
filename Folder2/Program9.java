import java.util.Scanner;
public class Program9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[5];
        for(int i=0; i<5; i++){
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<5; i++){
            if(isPositive(arr[i])){
                System.out.print("Number " + arr[i] + " is positive");
                if(isEven(arr[i])){
                    System.out.println(" and even");
                } 
				else{
                    System.out.println(" and odd");
                }
            } 
			else{
                System.out.println("Number " + arr[i] + " is negative");
            }
        }
        int comparison = compare(arr[0], arr[4]);
        if(comparison == 1){
            System.out.println("First number is greater than last number");
        } 
		else if(comparison == 0){
            System.out.println("First number is equal to last number");
        } 
		else{
            System.out.println("First number is less than last number");
        }
    }
    public static boolean isPositive(int number){
        return number > 0;
    }
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
    public static int compare(int number1, int number2){
        if(number1 > number2){
            return 1;
        } 
		else if(number1 == number2){
            return 0;
        }
		else{
            return -1;
        }
    }
}