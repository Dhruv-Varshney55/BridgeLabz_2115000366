import java.io.*;
public class BufferedStreams{
    private static final int BUFFER_SIZE = 4096;
	
    public static void main(String[] args){
        String file = "Text.txt";
        String bufferFile = "buffered.txt";
        String unbufferFile = "unbuffered.txt";
		
        long start = System.nanoTime();
        copyUsingBuffered(file, bufferFile);
        long bufferTime = System.nanoTime() - start;

        start = System.nanoTime();
        copyUsingUnbuffered(file, unbufferFile);
        long unbufferTime = System.nanoTime() - start;

        System.out.println("Buffered Streams Time: " + (bufferTime / 1000000) + " ms");
        System.out.println("Unbuffered Streams Time: " + (unbufferTime / 1000000) + " ms");
    }

    private static void copyUsingBuffered(String src, String dest){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while((bytesRead = bis.read(buffer)) != -1){
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy completed");
        }
		catch(IOException e){
            System.out.println("Error in Buffered Copy: " + e.getMessage());
        }
    }

    private static void copyUsingUnbuffered(String src, String dest){
        try(FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dest)){
            int byteData;
            while((byteData = fis.read()) != -1){
                fos.write(byteData);
            }
            System.out.println("Unbuffered Copy Completed");
        }
		catch(IOException e){
            System.out.println("Error in Unbuffered Copy: " + e.getMessage());
        }
    }
}