public class CompareBuilderBufferAndString{
    public static void main(String[] args){
        int[] dataSize = {1000, 10000, 1000000};
        for(int size : dataSize){
            System.out.println("Size: " + size);
			
            long start = System.nanoTime();
            stringConcat(size);
            long stringTime = System.nanoTime() - start;
            System.out.println("String Time: " + (stringTime / 1000000.f) + " ms");

            start = System.nanoTime();
            stringBuilderConcat(size);
            long stringBuilderTime = System.nanoTime() - start;
            System.out.println("StringBuilder Time: " + (stringBuilderTime / 1000000.0f) + " ms");

            start = System.nanoTime();
            stringBufferConcat(size);
            long stringBufferTime = System.nanoTime() - start;
            System.out.println("StringBuffer Time: " + (stringBufferTime / 1000000.0f) + " ms");
            System.out.println();
        }
    }

    public static void stringConcat(int n){
        String str = "";
        for(int i=0; i<n; i++){
            str += "a";
        }
    }

    public static void stringBuilderConcat(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<n; i++){ 
            sb.append("a");
        }
    }

    public static void stringBufferConcat(int n){
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<n; i++){
            sb.append("a");
        }
    }
}