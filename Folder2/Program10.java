import java.util.Scanner;
public class Program10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of chocolates: ");
        int chocolates = sc.nextInt();
        System.out.print("Enter the number of children: ");
        int children = sc.nextInt();
        int chocoPerChild = chocolates / children;
        int remainingChoco = chocolates % children;
        System.out.println("The number of chocolates each child gets is " + chocoPerChild + " and the number of remaining chocolates is " + remainingChoco);
    }
}