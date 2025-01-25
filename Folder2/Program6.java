import java.util.Scanner;
public class Program6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();
        double [] ht = new double[n];
        double [] wt = new double[n];
        double [] bmi = new double[n];
        String [] status = new String[n];
        for(int i=0; i<n; i++){
            System.out.print("Enter height in m for person " + (i + 1) + ": ");
            ht[i] = sc.nextDouble();
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            wt[i] = sc.nextDouble();
        }
        for(int i=0; i<n; i++){
            bmi[i] = wt[i] / (ht[i] * ht[i]);
            if(bmi[i] <= 18.4){
                status[i] = "Underweight";
            } 
			else if(bmi[i] >= 18.5 && bmi[i] <= 24.9){
                status[i] = "Normal";
            } 
			else if(bmi[i] >= 25.0 && bmi[i] <= 39.9){
                status[i] = "Overweight";
            } 
			else{
                status[i] = "Obese";
            }
        }
        System.out.println("\nHeight(m) | Weight(kg)  | BMI      | Status");
        for(int i=0; i<n; i++){
            System.out.printf("%.2f      | %.2f       | %.2f    | %s\n", ht[i], wt[i], bmi[i], status[i]);
        }
    }
}