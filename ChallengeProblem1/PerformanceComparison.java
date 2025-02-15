import java.io.*;
import java.util.StringTokenizer;
public class PerformanceComparison{
    public static void main(String[] args){
        compareBuilderAndBuffer();
        compareFileReaderAndInputStreamReader("Greetings.txt");
    }

    public static void compareBuilderAndBuffer(){
        String text = "hello";
        int n = 1000000;
	
        long start = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0; i<n; i++){
            sb1.append(text);
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1000000 + " ms");

        start = System.nanoTime();
        StringBuffer sb2 = new StringBuffer();
        for(int i=0; i<n; i++){
            sb2.append(text);
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1000000 + " ms");
    }

    public static void compareFileReaderAndInputStreamReader(String filePath){
        long start, end;
        int count;

        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr)){
            start = System.nanoTime();
            count = countWords(br);
            end = System.nanoTime();
            System.out.println("FileReader Word Count: " + count);
            System.out.println("FileReader Time: " + (end - start) / 1000000 + " ms");
        }
		catch (IOException e){
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            BufferedReader br = new BufferedReader(isr)){
            start = System.nanoTime();
            count = countWords(br);
            end = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + count);
            System.out.println("InputStreamReader Time: " + (end - start) / 1000000 + " ms");

        }
		catch(IOException e){
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }

    public static int countWords(BufferedReader br) throws IOException{
        int count = 0;
        String line;
        while((line = br.readLine()) != null){
            StringTokenizer t = new StringTokenizer(line);
            count += t.countTokens();
        }
        return count;
    }
}