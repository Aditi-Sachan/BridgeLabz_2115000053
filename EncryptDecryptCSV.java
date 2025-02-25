import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

class EncryptDecryptCSV {
    private static final String KEY = "1234567890123456";
    
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String encryptedFile = "encrypted_employees.csv";
        String decryptedFile = "decrypted_employees.csv";
        encryptCSV(inputFile, encryptedFile);
        decryptCSV(encryptedFile, decryptedFile);
    }

    public static void encryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String header = br.readLine();
            bw.write(header);
            bw.newLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                data[3] = encrypt(data[3]);
                data[4] = encrypt(data[4]);
                bw.write(String.join(",", data));
                bw.newLine();
            }
            System.out.println("CSV encryption completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void decryptCSV(String inputFile, String outputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            String header = br.readLine();
            bw.write(header);
            bw.newLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                data[3] = decrypt(data[3]);
                data[4] = decrypt(data[4]);
                bw.write(String.join(",", data));
                bw.newLine();
            }
            System.out.println("CSV decryption completed.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting", e);
        }
    }

    private static String decrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(value)));
        } catch (Exception e) {
            throw new RuntimeException("Error decrypting", e);
        }
    }
}
