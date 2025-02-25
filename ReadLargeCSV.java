import java.io.*;

class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_data.csv";
        int batchSize = 100;
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                count++;
                if (count % batchSize == 0) {
                    System.out.println("Processed records: " + count);
                }
            }
            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

