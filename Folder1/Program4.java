public class Program4{
    public static void main(String[] args){
        int cp = 129, sp = 191;
        int profit = sp - cp;
        float profitPercentage = (profit / (float)cp) * 100;
        System.out.println("The Cost Price is INR " + cp + " and Selling Price is INR " + sp + "\nThe Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage + "%");
    }
}
