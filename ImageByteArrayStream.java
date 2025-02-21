import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


class ImageByteArrayStream {
    public static void main(String[] args) {
        String sourceImage = "tree.jpg";
        String destinationImage = "house.jpg";
        
        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(sourceImage));
            
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
                
                int byteData;
                while ((byteData = bais.read()) != -1) {
                    baos.write(byteData);
                }
                
                Files.write(Paths.get(destinationImage), baos.toByteArray());
                System.out.println("Image copied successfully.");
            }
        } catch (IOException e) {
            System.out.println("Error processing the image: " + e.getMessage());
        }
    }
}
