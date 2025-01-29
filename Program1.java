import java.util.Scanner;
public class Program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
        String str = sc.nextLine().toLowerCase();
        int vowels = 0, cons = 0;
        for(char ch : str.toCharArray()){
            if(ch>='a' && ch<='z'){
                if("aeiou".indexOf(ch) != -1){
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