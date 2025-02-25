import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSVData{

    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }

    public static void encryptCSV(String inputFile, String encryptedFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFile))) {

            String headerLine = reader.readLine();
            writer.write(headerLine);
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                values[3] = encrypt(values[3]);
                values[4] = encrypt(values[4]);
                writer.write(String.join(",", values));
                writer.newLine();
            }
            System.out.println("Encrypted CSV saved: " + encryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void decryptCSV(String encryptedFile, String decryptedFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(encryptedFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(decryptedFile))) {

            String headerLine = reader.readLine();
            writer.write(headerLine);
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                values[3] = decrypt(values[3]);
                values[4] = decrypt(values[4]);
                writer.write(String.join(",", values));
                writer.newLine();
            }
            System.out.println("Decrypted CSV saved: " + decryptedFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFile = "EmployeesX.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";

        encryptCSV(inputFile, encryptedFile);
        decryptCSV(encryptedFile, decryptedFile);
    }
}