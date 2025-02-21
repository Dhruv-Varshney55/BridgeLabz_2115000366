import java.io.*;
class WriterThread extends Thread{
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos){
        this.pos = pos;
    }

    @Override
    public void run(){
        try{
            String message = "Hello from WriterThread!";
            System.out.println("Writer: Writing message...");
            pos.write(message.getBytes());
            pos.close();
        }
		catch(IOException e){
            System.err.println("Writer Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread{
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis){
        this.pis = pis;
    }

    @Override
    public void run(){
        try{
            System.out.println("Reader: Reading message...");
            int data;
            while((data = pis.read()) != -1){
                System.out.print((char) data);
            }
            pis.close();
            System.out.println("\nReader: Reading complete");
        }
		catch(IOException e){
            System.err.println("Reader Error: " + e.getMessage());
        }
    }
}

public class PipedStreams{
    public static void main(String[] args){
        try{
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

            writer.join();
            reader.join();
        }
		catch(IOException | InterruptedException e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}