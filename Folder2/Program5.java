import java.util.Scanner;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int c = 0, temp = num;
        while(temp != 0){
            c++;
            temp /= 10;
        }
        int [] arr = new int[c];
        int idx = 0;
        while(num != 0){
            arr[idx++] = num % 10;
            num /= 10;
        }
        System.out.println("Reversed digits:");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}