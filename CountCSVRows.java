import java.io.*;

class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "data.csv";
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                rowCount++;
            }
            System.out.println("Total records: " + rowCount);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
