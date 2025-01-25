import java.util.Scanner;
public class Program2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] age = new int[3];
        int [] height = new int[3];
        String [] name = {"Amar", "Akbar", "Anthony"};
        for(int i=0; i<3; i++){
            System.out.print("Enter age of " + name[i] + ": ");
            age[i] = sc.nextInt();
            System.out.print("Enter height of " + name[i] + ": ");
            height[i] = sc.nextInt();
        }
        int youngest = 0;
        int tallest = 0;
        for(int i=1; i<3; i++){
            if(age[i] < age[youngest]){
                youngest = i;
            }
            if(height[i] > height[tallest]){
                tallest = i;
            }
        }
        System.out.println("\nYoungest friend: " + name[youngest]);
        System.out.println("Tallest friend: " + name[tallest]);
    }
}