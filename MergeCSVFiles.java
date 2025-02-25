import java.io.*;
import java.util.*;

class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";
        Map<String, String[]> studentData = new HashMap<>();
        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            br1.readLine();
            String line;
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                studentData.put(data[0], new String[]{data[1], data[2], "", ""});
            }
        } catch (IOException e) {
            System.out.println("Error reading file1: " + e.getMessage());
        }
        try (BufferedReader br2 = new BufferedReader(new FileReader(file2))) {
            br2.readLine();
            String line;
            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                if (studentData.containsKey(data[0])) {
                    studentData.get(data[0])[2] = data[1];
                    studentData.get(data[0])[3] = data[2];
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file2: " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            bw.newLine();
            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                bw.write(entry.getKey() + "," + String.join(",", entry.getValue()));
                bw.newLine();
            }
            System.out.println("Merged file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}
