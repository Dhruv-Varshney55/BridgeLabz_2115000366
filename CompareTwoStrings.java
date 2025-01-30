import java.util.Scanner;
public class CompareTwoStrings{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();
        int ans = compareStrings(str1, str2);
        if(ans < 0){
            System.out.println(str1 + " comes before " + str2 + " in lexicographical order");
        } 
		else if(ans > 0){
            System.out.println(str1 + " comes after " + str2 + " in lexicographical order");
        }
		else{
            System.out.println(str1 + " and " + str2 + " are equal");
        }
    }

    public static int compareStrings(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);
        for(int i=0; i<minLen; i++){
            if(str1.charAt(i) < str2.charAt(i)){
                return -1;
            } 
			else if(str1.charAt(i) > str2.charAt(i)){
                return 1;
            }
        }
        if(len1 < len2){
			return -1;
		}
        else if(len1 > len2){
			return 1;
		}
        return 0;
    }
}