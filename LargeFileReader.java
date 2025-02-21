import java.io.*;
import java.nio.charset.StandardCharsets;

class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "large_file.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
