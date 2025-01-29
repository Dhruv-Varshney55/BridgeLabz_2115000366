import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Modified String: " + removeDuplicates(str));
    }
    public static String removeDuplicates(String str){
        String ans = "";
        for(char ch : str.toCharArray()){
            if(ans.indexOf(ch) == -1){
				ans += ch;
			}
        }
        return ans;
    }
}