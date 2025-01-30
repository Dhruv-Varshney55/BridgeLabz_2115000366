import java.util.Scanner;
public class VowelsAndConsonants{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        countVowelsAndConsonants(str);
    }

    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, cons = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ch = (char) (ch + ('a' - 'A'));
            }
            if(ch >= 'a' && ch <= 'z'){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowels++;
                }
				else{
                    cons++;
                }
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + cons);
    }
}