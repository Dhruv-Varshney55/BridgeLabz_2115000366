import java.util.Scanner;
public class Program3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks for Physics: ");
        int physics = sc.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = sc.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = sc.nextInt();
        float avg = (physics + chemistry + maths) / 3.0f;
        System.out.println("Average Marks: " + avg);
        if(avg >= 80){
            System.out.println("Level 4, above agency-normalized standards");
        } 
		else if(avg >= 70){
            System.out.println("Level 3, at agency-normalized standards");
        } 
		else if(avg >= 60){
            System.out.println("Level 2, below, but approaching agency-normalized standards");
        } 
		else if(avg >= 50){
            System.out.println("Level 1, well below agency-normalized standards");
        }
		else if(avg >= 40){
            System.out.println("Level 1-, too below agency-normalized standards");
        }
		else{
            System.out.println("Remedial standards");
        }
    }
}