import java.util.Scanner;
public class RemoveSpecificCharacter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.print("Enter a character to remove: ");
        char ch = sc.next().charAt(0);
        System.out.println("Modified String: " + removeCharacter(str, ch));
    }
	
    public static String removeCharacter(String str, char ch){
        char [] arr = new char[str.length()];
        int idx = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != ch){
                arr[idx++] = str.charAt(i);
            }
        }
        return new String(arr, 0, idx);
    }
}