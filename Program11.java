import java.util.*;
public class Program11{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = sc.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = sc.nextLine();
        if(areAnagrams(str1, str2)){
            System.out.println("Anagram");
        } 
		else{
            System.out.println("Not Anagram");
        }
    }

    public static boolean areAnagrams(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}