import java.util.Arrays;
public class Program12{
    public static void main(String[] args){
        int size = 5;
        int [] random = generateRandom(size);
        System.out.println("Generated 4-digit 5 random numbers: " + Arrays.toString(random));
        double [] results = AvgMinMax(random);
        System.out.printf("Average: %.2f%n", results[0]);
        System.out.println("Minimum: " + (int) results[1]);
        System.out.println("Maximum: " + (int) results[2]);
    }
    public static int[] generateRandom(int size){
        int [] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = 1000 + (int) (Math.random() * 9000);
        }
        return numbers;
    }
    public static double[] AvgMinMax(int[] numbers){
        double sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num : numbers){
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = sum / 5;
        return new double[]{average, min, max};
    }
}