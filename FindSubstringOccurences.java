import java.util.Scanner;
public class FindSubstringOccurences{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        System.out.print("Enter Substring: ");
        String subStr = sc.nextLine();
        System.out.println("Number of occurrences: " + subStrOccurrences(str, subStr));
    }
    public static int subStrOccurrences(String str, String subStr){
        int m = str.length();
        int n = subStr.length();
        int ans = 0;
        for(int i=0; i<=m-n; i++){
			int j;
            for(j=0; j<n; j++){
                if(str.charAt(i+j) != subStr.charAt(j)){
                    break;
                }
            }
            if(j == n){
                ans++;
                j = 0;
            }
        }
        return ans;
    }
}