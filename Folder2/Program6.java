import java.util.Scanner;
public class Program6{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter salary: ");
        int salary = sc.nextInt();
        System.out.print("Enter bonus: ");
        int bonus = sc.nextInt();
        int income = salary + bonus;
        System.out.println("The salary is INR " + salary + " and bonus is INR " + bonus + ". Hence Total Income is INR " + income);
    }
}