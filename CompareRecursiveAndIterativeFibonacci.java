public class CompareRecursiveAndIterativeFibonacci{
    public static void main(String[] args){
        int[] arr = {10, 30, 50};
        for(int n : arr){
            System.out.println("Fibonacci(" + n + ")");
            
            long start = System.nanoTime();
            int recursiveResult = fibRecursive(n);
            long recursiveTime = System.nanoTime() - start;
            System.out.println("Recursive Time: " + (recursiveTime / 1000000.0f) + " ms");

            start = System.nanoTime();
            int iterativeResult = fibIterative(n);
            long iterativeTime = System.nanoTime() - start;
            System.out.println("Iterative Time: " + (iterativeTime / 1000000.0f) + " ms");
            System.out.println();
        }
    }

    public static int fibRecursive(int n){
        if(n <= 1){
			return n;
		}
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibIterative(int n){
        if(n <= 1){
			return n;
		}
        int a=0, b=1, c;
        for(int i=2; i<=n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}