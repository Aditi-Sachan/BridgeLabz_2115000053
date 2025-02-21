import java.io.*;
class Copy {
    public static void main(String[] args) {
        String sourceFile = "large_source.txt";
        String destinationFileBuffered = "destination_buffered.txt";
        String destinationFileUnbuffered = "destination_unbuffered.txt";
        
        long startTime, endTime;
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFileUnbuffered)) {
            int byteData;
            startTime = System.nanoTime();
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endTime - startTime) + " nanoseconds");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFileBuffered))) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            System.out.println("Buffered copy time: " + (endTime - startTime) + " nanoseconds");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
