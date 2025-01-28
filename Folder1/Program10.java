import java.util.Scanner;
public class Program10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of chocolates: ");
        int choco = sc.nextInt();
        System.out.print("Enter the number of children: ");
        int child = sc.nextInt();
        if(child > 0){
            distributeChocolates(choco, child);
        } 
		else{
            System.out.println("Number of children cannot be zero or negative.");
        }
    }
	public static void distributeChocolates(int choco, int child){
        int chocoPerChild = choco / child;
        int remainingChoco = choco % child;
        System.out.println("Each child will get " + chocoPerChild + " chocolates");
        System.out.println("Remaining chocolates: " + remainingChoco);
    }
}