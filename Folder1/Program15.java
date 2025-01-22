import java.util.Scanner;
public class Program15{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the unit price of the item: ");
        int price = sc.nextInt();
        System.out.print("Enter the quantity to be bought: ");
        int quantity = sc.nextInt();
        int totalPrice = price * quantity;
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and unit price is INR " + price);
    }
}
