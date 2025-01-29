import java.util.Scanner;
public class Program7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.println("Toggled String: " + toggleCase(str));
    }

    public static String toggleCase(String str){
        String s = "";
        for(int i=0; i<str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                s += Character.toLowerCase(str.charAt(i));
            } 
			else{
                s += Character.toUpperCase(str.charAt(i));
            }
        }
        return s;
    }
}