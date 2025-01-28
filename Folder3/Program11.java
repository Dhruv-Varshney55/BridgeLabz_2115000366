import java.util.*;
public class Program11{
	public static void main(String[] args){
        double [][] employeeData = salaryAndYearsOfService();
        double [][] updatedData = newSalaryAndBonus(employeeData);
        calculateAndDisplay(updatedData);
    }
	
    public static double [][] salaryAndYearsOfService(){
        double [][] employeeData = new double[10][2];
        Random rand = new Random();
        for(int i=0; i<10; i++){
            employeeData[i][0] = 10000 + rand.nextInt(90000);
            employeeData[i][1] = 1 + rand.nextInt(20);
        }
        return employeeData;
    }

    public static double[][] newSalaryAndBonus(double[][] employeeData){
        double [][] updatedData = new double[10][3];
        for(int i=0; i<10; i++){
            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonus = (yearsOfService > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;   
            updatedData[i][0] = salary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }
        return updatedData;
    }

    public static void calculateAndDisplay(double[][] updatedData){
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Employee", "Old Salary", "New Salary", "Bonus");
        System.out.println("------------------------------------------------------------");
        for(int i=0; i<10; i++){
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f\n", i+1, updatedData[i][0], updatedData[i][1], updatedData[i][2]);
        }   
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-15.2f%-15.2f%-15.2f\n", "Total", totalOldSalary, totalNewSalary, totalBonus);
    }
}