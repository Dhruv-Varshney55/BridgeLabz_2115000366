import java.io.*;

public class ReadLargeCSV{
    public static void main(String[] args){
        String file = "Data.csv";
        int batchSize = 100;
        int totalRecords = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            boolean isHeader = true;
            int batchCount = 0;
            while((line = reader.readLine()) != null){
                if(isHeader){
                    isHeader = false;
                    continue;
                }
                batchCount++;
                totalRecords++;
                if(batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records so far...");
                    batchCount = 0;
                }
            }
            System.out.println("Total records processed: " + totalRecords);
        }
		catch(IOException e){
            System.out.println("An error occurred while reading the CSV file.");
            e.printStackTrace();
        }
    }
}