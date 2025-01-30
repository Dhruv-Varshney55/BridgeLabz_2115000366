import java.util.Scanner;
public class ToggleCaseCharacters{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.println("Toggled String: " + toggleCase(str));
    }

    public static String toggleCase(String str){
        String s = "";
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char) (ch + 'a' - 'A');
            }
			else if(ch >= 'a' && ch <= 'z'){
                ch = (char) (ch - 'a' + 'A');
            }
            s += ch;
        }
        return s;
    }
}