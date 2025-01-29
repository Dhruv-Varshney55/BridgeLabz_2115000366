import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.print("Enter a character to remove: ");
        char ch = sc.next().charAt(0);
        System.out.println("Modified String: " + removeCharacter(str, ch));
    }
	
    public static String removeCharacter(String str, char ch){
        return str.replace(String.valueOf(ch), "");
    }
}