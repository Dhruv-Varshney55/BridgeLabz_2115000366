import java.util.Scanner;
public class Program9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the fee: ");
        float fee = sc.nextFloat();
        System.out.print("Enter the discount percent: ");
        float discountPercent = sc.nextFloat();
        float discount = (fee * discountPercent) / 100;
        float finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}