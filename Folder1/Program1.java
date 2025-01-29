import java.util.*;
public class Program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low = 1, high = 100;
		int guess;
        String str;
        System.out.println("Think of a number between 1 and 100, The computer will try to guess it.");
        while(true){
            guess = numberGuess(low, high, rand);
            System.out.println("Is your number " + guess + "? (Enter 'high', 'low', or 'correct')");
            str = sc.nextLine().trim().toLowerCase();
            if(str.equals("correct")){
                System.out.println("Great! The computer guessed your number.");
                break;
            } 
			else if(str.equals("high")){
                high = guess - 1;
            }
			else if(str.equals("low")){
                low = guess + 1;
            }
			else{
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }
    }

    public static int numberGuess(int low, int high, Random rand){
        return low + rand.nextInt(high - low + 1);
    }
}