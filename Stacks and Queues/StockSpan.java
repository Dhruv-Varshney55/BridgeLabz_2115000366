import java.util.Stack;
public class StockSpan{
	public static void main(String[] args){
        int[] prices = {85, 60, 70, 60, 90, 55, 35};
        int[] span = calculate(prices);
        for(int price : prices){
            System.out.print(price + " ");
        }
        System.out.println();
        for(int s : span){
            System.out.print(s + " ");
        }
    }
	
    public static int[] calculate(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && prices[st.peek()] <= prices[i]){
                st.pop();
            }
            span[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }
        return span;
    }
}