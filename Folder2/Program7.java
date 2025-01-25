import java.util.Scanner;
public class Program7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        for(int i=0; i<n; i++){
            System.out.print("Enter height in m for person " + (i + 1) + ": ");
            personData[i][0] = sc.nextDouble();
            while(personData[i][0] <= 0){
                System.out.println("Height must be positive, Please enter again.");
                personData[i][0] = sc.nextDouble();
            }
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            personData[i][1] = sc.nextDouble();
            while(personData[i][1] <= 0){
                System.out.println("Weight must be positive, Please enter again.");
                personData[i][1] = sc.nextDouble();
            }
        }
        for(int i=0; i<n; i++){
            personData[i][2] = personData[i][1] / (personData[i][0] * personData[i][0]);
            if(personData[i][2] <= 18.4){
                weightStatus[i] = "Underweight";
            } 
			else if(personData[i][2] >= 18.5 && personData[i][2] <= 24.9){
                weightStatus[i] = "Normal";
            } 
			else if(personData[i][2] >= 25.0 && personData[i][2] <= 39.9){
                weightStatus[i] = "Overweight";
            } 
			else{
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nHeight(m) | Weight(kg)  | BMI      | Status");
        for(int i=0; i<n; i++){
            System.out.printf("%.2f      | %.2f       | %.2f    | %s\n", personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}