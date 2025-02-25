import java.io.*;
import java.util.*;

class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "data.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!uniqueIds.add(data[0])) {
                    duplicates.add(line);
                }
            }
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate records:");
                for (String record : duplicates) {
                    System.out.println(record);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
