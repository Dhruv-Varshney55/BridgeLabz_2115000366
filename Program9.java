import java.util.Scanner;
public class Program9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Most Frequent Character: " + mostFrequentChar(str));
    }

    public static char mostFrequentChar(String str){
        int [] freq = new int[256];
        int maxFreq = 0;
        char ans = ' ';
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            freq[ch]++;
            if(freq[ch] > maxFreq){
                maxFreq = freq[ch];
                ans = ch;
            }
        }
        return ans;
    }
}