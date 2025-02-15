public class WordSearch{
	public static void main(String[] args){
        String[] sentences = {
            "Twinkle, twinkle, little star",
			"How I wonder what you are",
			"Up above the world so high",
			"Like a diamond in the sky"
        };
        String word = "diamond";
        String ans = findWord(sentences, word);
        System.out.println("Sentence containing '" + word + "': " + ans);
    }
	
    public static String findWord(String[] sentences, String word){
        for(String sentence : sentences){
            if(sentence.contains(word)){
                return sentence;
            }
        }
        return "Not Found";
    }   
}