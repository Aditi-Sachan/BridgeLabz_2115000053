import java.io.*;
import java.nio.charset.StandardCharsets;

class FileConverter {
    public static void main(String[] args) {
        String sourceFile = "Stack.txt";
        String destinationFile = "emp.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile, StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile, StandardCharsets.UTF_8))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("Error processing the file: " + e.getMessage());
        }
    }
}
