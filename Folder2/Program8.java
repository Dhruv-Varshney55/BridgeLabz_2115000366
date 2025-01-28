import java.util.Scanner;
public class Program8{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] ages = new int[3];
        int [] heights = new int[3];
        for(int i=0; i<3; i++){
            System.out.print("Enter age of " + getFriendName(i) + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Enter height of " + getFriendName(i) + ": ");
            heights[i] = sc.nextInt();
        }
        int young = findYoungest(ages);
        int tall = findTallest(heights);
        System.out.println("Youngest friend is " + getFriendName(young));
        System.out.println("Tallest friend is " + getFriendName(tall));
    }
    public static int findYoungest(int[] ages){
        int youngest = ages[0];
        int young = 0;
        for(int i=1; i<ages.length; i++){
            if(ages[i] < youngest){
                youngest = ages[i];
                young = i;
            }
        }
        return young;
    }
    public static int findTallest(int[] heights){
        int tallest = heights[0];
        int tall = 0;
        for(int i=1; i<heights.length; i++){
            if(heights[i] > tallest){
                tallest = heights[i];
                tall = i;
            }
        }
        return tall;
    }
    public static String getFriendName(int i){
        String [] friends = {"Amar", "Akbar", "Anthony"};
        return friends[i];
    }
}