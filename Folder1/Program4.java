import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double total = 0.0;
        int index = 0;
        System.out.println("Enter numbers:");
        while(true){
            double n = sc.nextDouble();
            if(n<=0 || index==10){
                break;
            }
            arr[index++] = n;
        }
        System.out.println("Numbers entered are:");
        for(int i=0; i<index; i++){
            System.out.print(arr[i] + " ");
            total += arr[i];
        }
		System.out.println();
        System.out.println("Total: " + total);
    }
}