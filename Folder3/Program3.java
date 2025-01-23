import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        int sum = 0;
        int orgNum = num;
        while(orgNum != 0){
            sum += orgNum % 10;
            orgNum /= 10;
        }
        if(num % sum == 0){
            System.out.println("Harshad number");
        } 
		else{
            System.out.println("Not a Harshad number");
        }
    }
}