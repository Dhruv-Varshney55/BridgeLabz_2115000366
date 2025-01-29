import java.util.Scanner;
public class Program5{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        System.out.println("Longest Word: " + longestWord(str));
    }
    public static String longestWord(String str){
        String [] strArr = str.split(" ");
        String longest = "";
        for(String word : strArr){
            if(word.length() > longest.length()){
				longest = word;
			}
        }
        return longest;
    }
}