import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double [][] data = new double[10][3];
        String [] status = new String[10];
        for(int i=0; i<10; i++){
            System.out.printf("Enter weight (in kg) for person %d: ", i + 1);
            data[i][0] = sc.nextDouble();
            System.out.printf("Enter height (in cm) for person %d: ", i + 1);
            data[i][1] = sc.nextDouble();
        }
        calculateBMI(data);
        determineStatus(data, status);
        System.out.printf("%-10s %-10s %-10s %-20s%n", "Weight(kg)", "Height(cm)", "BMI", "Status");
        for(int i=0; i<10; i++){
            System.out.printf("%-10.2f %-10.2f %-10.2f %-20s%n", data[i][0], data[i][1], data[i][2], status[i]);
        }
    }
    public static void calculateBMI(double [][] data){
        for(int i=0; i<data.length; i++){
            double heightInMeters = data[i][1] / 100;
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }
    public static void determineStatus(double [][] data, String [] status){
        for(int i=0; i<data.length; i++){
            double bmi = data[i][2];
            if(bmi <= 18.4){
                status[i] = "Underweight";
            } 
			else if(bmi >= 18.5 && bmi <= 24.9){
                status[i] = "Normal";
            }
			else if(bmi >= 25.0 && bmi <= 39.9){
                status[i] = "Overweight";
            }
			else{
                status[i] = "Obese";
            }
        }
    }
}