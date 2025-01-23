import java.util.Scanner;
public class Program17{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee's salary: ");
        int salary = sc.nextInt();
        System.out.print("Enter the years of service: ");
        int years = sc.nextInt();
        if(years > 5){
            float bonus = salary * 0.05f;
            System.out.println("The bonus is " + bonus);
        } 
		else{
            System.out.println("No bonus for employees with 5 or less than 5 years of service.");
        }
    }
}