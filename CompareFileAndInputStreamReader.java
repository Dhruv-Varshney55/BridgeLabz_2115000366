import java.io.*;
public class CompareFileAndInputStreamReader{
    public static void main(String[] args){
        String[] files = {"Java1.txt", "Java2.txt", "Java3.txt"};
        long start, frTime, isrTime;
        for(int i=0; i<files.length; i++){
            String file = files[i];
            String fileSize = (i == 0) ? "Size: 1MB" : (i == 1) ? "Size: 100MB" : "Size: 500MB";
            System.out.println(fileSize);
            
            start = System.nanoTime();
            fileReader(file);
            frTime = System.nanoTime() - start;
            System.out.println("FileReader Time: " + (frTime / 1000000.0f) + " ms");

            start = System.nanoTime();
            inputStreamReader(file);
            isrTime = System.nanoTime() - start;
            System.out.println("InputStreamReader Time: " + (isrTime / 1000000.0f) + " ms");
            System.out.println();
		}
    }

    public static void fileReader(String file){
        try(FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr)){
            while(br.read() != -1){}
        }
		catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void inputStreamReader(String file){
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr)){
            while(br.read() != -1){}
        }
		catch(IOException e){
            e.printStackTrace();
        }
    }
}