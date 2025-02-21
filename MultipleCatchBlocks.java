import java.util.Scanner;
public class MultipleCatchBlocks{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer[] arr = {10, 20, 30, 40, 50};
		// Integer[] arr = null;
        try{
            System.out.print("Enter an index: ");
            int index = sc.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
        }
		catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index");
        }
		catch(NullPointerException e){
            System.out.println("Array is not initialized");
        }
		catch(Exception e){
            System.out.println("An unexpected error occurred");
        }
    }
}