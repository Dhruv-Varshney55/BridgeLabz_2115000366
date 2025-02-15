public class BufferVsBuilder{
    public static void main(String[] args){
        int n = 1000000;
        String str = "hello";
		
        long start1 = System.nanoTime();
        StringBuffer sb1 = new StringBuffer();
        for(int i=0; i<n; i++){
            sb1.append(str);
        }
        long end1 = System.nanoTime();
        long bufferTime = end1 - start1;

        long start2 = System.nanoTime();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0; i<n; i++){
            sb2.append(str);
        }
        long end2 = System.nanoTime();
        long builderTime = end2 - start2;

        System.out.println("Time taken by StringBuffer: " + bufferTime / 1000000 + " ms");
        System.out.println("Time taken by StringBuilder: " + builderTime / 1000000 + " ms");
    }
}