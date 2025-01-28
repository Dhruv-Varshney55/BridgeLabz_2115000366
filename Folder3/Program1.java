import java.util.Arrays;
public class Program1{
    public static void main(String[] args){
        int [] heights = generateHeights(11);
        System.out.println("Player Heights (cm): " + Arrays.toString(heights));
        System.out.println("Shortest Height: " + shortestHeight(heights) + " cm");
        System.out.println("Tallest Height: " + tallestHeight(heights) + " cm");
        System.out.printf("Mean Height: %.2f cm%n", meanHeight(heights));
    }
    public static int[] generateHeights(int size){
        int [] heights = new int[size];
        for(int i=0; i<size; i++){
            heights[i] = 150 + (int) (Math.random() * 101);
        }
        return heights;
    }
    public static int shortestHeight(int[] heights){
        int shortest = Integer.MAX_VALUE;
        for(int height : heights){
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }
    public static int tallestHeight(int[] heights){
        int tallest = Integer.MIN_VALUE;
        for(int height : heights){
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }
    public static double meanHeight(int[] heights){
        int sum = 0;
        for(int height : heights){
            sum += height;
        }
        return (double) sum / heights.length;
    }
}