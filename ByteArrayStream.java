import java.io.*;
public class ByteArrayStream{
    public static void main(String[] args){
        String img = "Nature.jpg";
        String copyImg = "copyNature.jpg"; 
        byte[] imageBytes = readImageToByteArray(img);
        if(imageBytes != null){
            writeByteArrayToImage(imageBytes, copyImg);
            System.out.println("Image copied successfully");
        }
    }

    private static byte[] readImageToByteArray(String filePath){
        try(FileInputStream fis = new FileInputStream(filePath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = fis.read(buffer)) != -1){
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
		catch(IOException e){
            System.out.println("Error reading image: " + e.getMessage());
        }
        return null;
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String filePath){
        try(ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(filePath)){
            byte[] buffer = new byte[4096];
            int bytesRead;
            while((bytesRead = bais.read(buffer)) != -1){
                fos.write(buffer, 0, bytesRead);
            }
        }
		catch(IOException e){
            System.out.println("Error writing image: " + e.getMessage());
        }
    }
}