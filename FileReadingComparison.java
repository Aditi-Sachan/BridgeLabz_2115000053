import java.io.*;

class FileReadingComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "LinkedList.txt";
        
        long startTime = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - startTime;
        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms");
        
        startTime = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - startTime;
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms");
    }
    
    static void readUsingFileReader(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            while (reader.read() != -1) {}
        }
    }
    
    static void readUsingInputStreamReader(String filePath) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            while (reader.read() != -1) {}
        }
    }
}
