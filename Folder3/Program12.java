import java.util.*;
public class Program12{
    public static int[][] generateScores(int numStudents){
        int[][] scores = new int[numStudents][3];
        Random rand = new Random();
        for(int i=0; i<numStudents; i++){
            scores[i][0] = 50 + rand.nextInt(51);
            scores[i][1] = 50 + rand.nextInt(51);
            scores[i][2] = 50 + rand.nextInt(51);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores, int numStudents){
        double [][] results = new double[numStudents][5];
        for(int i=0; i<numStudents; i++){
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;
            String grade = calculateGrade(percentage);
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = Math.round(average * 100.0) / 100.0;
            results[i][3] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String calculateGrade(double percentage){
        if(percentage >= 80){
            return "Level 4, above agency-normalized students";
        }
		else if(percentage >= 70){
            return "Level 3, at agency-normalized students";
        } 
		else if(percentage >= 60){
            return "Level 2, below but approaching agency-normalized students";
        } 
		else if(percentage >= 50){
            return "Level 1, well below agency-normalized students";
        } 
		else if(percentage >= 40){
            return "Level 1-, too below agency-normalized students";
        } 
		else{
            return "Remedial standards";
        }
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[] grades, int numStudents){
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        for(int i=0; i<numStudents; i++){
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t%.2f\t\t%s\n", i + 1, scores[i][0], scores[i][1], scores[i][2], results[i][0], results[i][2], results[i][3], grades[i]);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores, numStudents);
		String[] grades = new String[numStudents];
        for(int i=0; i<numStudents; i++){
            double percentage = (results[i][3] / 100) * 100;
            grades[i] = calculateGrade(percentage);
        }
        displayScorecard(scores, results, grades, numStudents);
    }
}