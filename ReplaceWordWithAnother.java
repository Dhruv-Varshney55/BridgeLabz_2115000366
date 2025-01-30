import java.util.Scanner;
public class ReplaceWordWithAnother{
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
		char [] sentenceArray = sentence.toCharArray();
        char [] oldWordArray = oldWord.toCharArray();
        char [] newWordArray = newWord.toCharArray();
        char [] arr = new char[sentence.length() * 2];
        int idx = 0;
        int i = 0;
        while(i < sentenceArray.length){
            int j = 0;
            while(j<oldWordArray.length && i+j<sentenceArray.length && sentenceArray[i+j]==oldWordArray[j]){
                j++;
            }
            if(j == oldWordArray.length){
                for(char c : newWordArray){
                    arr[idx++] = c;
                }
                i += oldWordArray.length;
            }
			else{
                arr[idx++] = sentenceArray[i];
                i++;
            }
        }
        return new String(arr, 0, idx);
    }
}