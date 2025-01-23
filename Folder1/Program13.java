import java.util.Scanner;
public class Program13{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if(n > 0){
            int sumFormula = n * (n + 1) / 2;
            int sum = 0;
            for(int i = 1; i <= n; i++){
                sum += i;
            }
            System.out.println("Sum using formula: " + sumFormula);
			
            System.out.println("Sum using loop: " + sum);
            
			System.out.println("Both results are " + (sumFormula == sum ? "correct" : "not equal"));
        } 
		else{
            System.out.println("The number is not a natural number");
        }
    }
}