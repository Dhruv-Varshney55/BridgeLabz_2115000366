import java.util.*;
public class Anagram{
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
        char [] arr1 = new char[str1.length()];
        char [] arr2 = new char[str2.length()];
        for(int i=0; i<str1.length(); i++){
            arr1[i] = str1.charAt(i);
            arr2[i] = str2.charAt(i);
        }
        for(int i=0; i<arr1.length; i++){
            for(int j=i+1; j<arr1.length; j++){
                if(arr1[i] > arr1[j]){
                    char temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        for(int i=0; i<arr2.length; i++){
            for(int j=i+1; j<arr2.length; j++){
                if(arr2[i] > arr2[j]){
                    char temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}