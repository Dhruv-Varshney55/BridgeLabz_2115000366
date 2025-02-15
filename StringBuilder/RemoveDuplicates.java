import java.util.HashSet;
public class RemoveDuplicates{
    public static void main(String[] args){
        String str = "Assassination";
        System.out.println("Original String: " + str);
        String ans = removeDuplicates(str);
        System.out.println("After removing duplicates: " + ans);
    }

    public static String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(char ch : str.toCharArray()){
            if(!set.contains(ch)){
                sb.append(ch);
                set.add(ch);
            }
        }
        return sb.toString();
    }
}