import java.util.Scanner;
public class Program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] arr = new int[10];
        System.out.println("Enter the ages of 10 students:");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        for(int age : arr){
            if(age < 0){
                System.out.println("Invalid age");
            } 
			else if(age >= 18){
                System.out.println("The student with the age " + age + " can vote.");
            }
			else{
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
    }
}