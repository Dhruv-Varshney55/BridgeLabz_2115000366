import java.util.Scanner;
public class DuplicatesRemove{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Modified String: " + removeDuplicates(str));
    }

    public static String removeDuplicates(String str){
        char [] result = new char[str.length()];
        int idx = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            boolean found = false;
            for(int j=0; j<idx; j++){
                if(result[j] == ch){
                    found = true;
                    break;
                }
            }
            if(!found){
                result[idx] = ch;
                idx++;
            }
        }
        String modifiedStr = "";
        for (int i = 0; i < idx; i++) {
            modifiedStr += result[i];
        }
        return modifiedStr;
    }
}