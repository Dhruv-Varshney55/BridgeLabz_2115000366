import java.util.Scanner;
public class LongestWord{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        System.out.println("Longest Word: " + longestWord(str));
    }

    public static String longestWord(String str){
        char [] longest = new char[str.length()];
        int maxLen = 0, curLen = 0, startIndex = 0, maxStart = 0;
        for(int i=0; i<=str.length(); i++){
            char ch = (i < str.length()) ? str.charAt(i) : ' ';
            if(ch != ' '){
                if(curLen == 0){
					startIndex = i;
				}
                curLen++;
            }
			else{
                if(curLen > maxLen){
                    maxLen = curLen;
                    maxStart = startIndex;
                }
                curLen = 0;
            }
        }
        int index = 0;
        char [] result = new char[maxLen];
        for(int i=maxStart; i<maxStart + maxLen; i++){
            result[index++] = str.charAt(i);
        }
        return new String(result);
    }
}