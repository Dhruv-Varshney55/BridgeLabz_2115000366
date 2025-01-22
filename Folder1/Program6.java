public class Program6{
    public static void main(String[] args){
        float fee = 125000, discountPercent = 10;
        float discount = (fee * discountPercent) / 100;
        float finalFee = fee - discount;
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);
    }
}