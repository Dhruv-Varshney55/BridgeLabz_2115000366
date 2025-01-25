import java.util.Scanner;
public class Program8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        double [] marks = new double[n * 3];
        double [] percentages = new double[n];
        String [] grades = new String[n];
        for(int i=0; i<n; i++){
            System.out.print("Enter marks in Physics for student " + (i + 1) + ": ");
            marks[i * 3] = sc.nextDouble();
            if(marks[i * 3] < 0){
                System.out.println("Marks should be positive, Please enter again.");
                i--;
                continue;
            }
            System.out.print("Enter marks in Chemistry for student " + (i + 1) + ": ");
            marks[i * 3 + 1] = sc.nextDouble();
            if(marks[i * 3 + 1] < 0){
                System.out.println("Marks should be positive, Please enter again.");
                i--;
                continue;
            }
            System.out.print("Enter marks in Maths for student " + (i + 1) + ": ");
            marks[i * 3 + 2] = sc.nextDouble();
            if(marks[i * 3 + 2] < 0){
                System.out.println("Marks should be positive, Please enter again.");
                i--;
                continue;
            }
            double totalMarks = marks[i * 3] + marks[i * 3 + 1] + marks[i * 3 + 2];
            percentages[i] = (totalMarks / 300) * 100;
            System.out.println("Percentage: " + percentages[i]);
            if(percentages[i] >= 80){
				System.out.println("Level 4, above agency-normalized standards");
			} 
			else if(percentages[i] >= 70){
				System.out.println("Level 3, at agency-normalized standards");
			} 
			else if(percentages[i] >= 60){
				System.out.println("Level 2, below, but approaching agency-normalized standards");
			} 
			else if(percentages[i] >= 50){
				System.out.println("Level 1, well below agency-normalized standards");
			}
			else if(percentages[i] >= 40){
				System.out.println("Level 1-, too below agency-normalized standards");
			}
			else{
				System.out.println("Remedial standards");
			}
        }
    }
}