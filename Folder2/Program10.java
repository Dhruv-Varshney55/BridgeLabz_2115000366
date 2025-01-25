import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int [] freq = new int[10];
        String str = Integer.toString(num);
        for(int i=0; i<str.length(); i++){
            int digit = str.charAt(i) - '0';
            freq[digit]++;
        }
        System.out.println("Digit Frequency:");
        for(int i=0; i<10; i++){
            if(freq[i] > 0){
                System.out.println("Digit " + i + ": " + freq[i] + " times");
            }
        }
    }
}