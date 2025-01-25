import java.util.Scanner;
public class Program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int employees = 10;
        double [] salary = new double[employees];
        double [] serviceYears = new double[employees];
		double [] newSalary = new double[employees];
        double [] bonus = new double[employees];
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        for(int i=0; i<employees; i++){
            System.out.println("Enter details of Employee " + (i + 1) + ":");
            while(true){
                System.out.print("Enter salary: ");
                salary[i] = sc.nextDouble();
                if(salary[i] > 0){
                    break;
                }
				else{
                    System.out.println("Salary must be positive, Please enter again.");
                }
            }
            while(true){
                System.out.print("Enter years of service: ");
                serviceYears[i] = sc.nextDouble();
                if(serviceYears[i] >= 0){
                    break;
                }
				else{
                    System.out.println("Years of service must be positive, Please enter again.");
                }
            }
            if(serviceYears[i] > 5){
                bonus[i] = salary[i] * 0.05;
            } 
			else{
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("\nEmployee Bonuses and Salaries:");
		System.out.println();
        for(int i=0; i<employees; i++){
            System.out.printf("Employee %d -> Old Salary: %.2f, Bonus: %.2f, New Salary: %.2f\n", i + 1, salary[i], bonus[i], newSalary[i]);
        }
		System.out.println();
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
}