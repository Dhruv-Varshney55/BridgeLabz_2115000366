import java.util.Scanner;
public class Program12{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = sc.nextLine();
        System.out.print("Enter new word: ");
        String newWord = sc.nextLine();
        System.out.println("Modified Sentence: " + replaceWord(sentence, oldWord, newWord));
    }

    public static String replaceWord(String sentence, String oldWord, String newWord){
        return sentence.replaceAll(oldWord, newWord);
    }
}