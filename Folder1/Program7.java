import java.util.Scanner;
public class Program7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int num = sc.nextInt();
        if(num <= 0){
            System.out.println("Error: Not a natural number");
            return;
        }
        int [] even = new int[num / 2 + 1];
		int [] odd = new int[num / 2 + 1];
        int evenIndex = 0, oddIndex = 0;
        for(int i=1; i<=num; i++){
            if(i%2 == 0){
                even[evenIndex++] = i;
            }
			else{
                odd[oddIndex++] = i;
            }
        }
        System.out.println("Odd numbers:");
        for(int i=0; i<oddIndex; i++){
            System.out.print(odd[i] + " ");
        }
        System.out.println("\nEven numbers:");
        for(int i=0; i<evenIndex; i++){
            System.out.print(even[i] + " ");
        }
    }
}