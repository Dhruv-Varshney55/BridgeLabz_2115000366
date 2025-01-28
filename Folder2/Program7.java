import java.util.Scanner;
public class Program7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] ages = new int[10];
        for(int i=0; i<10; i++){
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
            boolean vote = voteChecker(ages[i]);
            if(vote){
                System.out.println("Student " + (i + 1) + " can vote");
            } 
			else{
                System.out.println("Student " + (i + 1) + " cannot vote");
            }
        }
    }
    public static boolean voteChecker(int age){
        if(age < 0){
            return false;
        }
        return age >= 18;
    }
}