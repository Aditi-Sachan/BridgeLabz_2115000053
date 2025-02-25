import java.io.*;
import java.util.*;
import org.json.*;

class JSONCSVConverter {
    public static void main(String[] args) {
        convertJsonToCsv("students.json", "students.csv");
        convertCsvToJson("students.csv", "students_converted.json");
    }

    public static void convertJsonToCsv(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line);
            }
            JSONArray students = new JSONArray(jsonContent.toString());
            bw.write("ID,Name,Age,Marks");
            bw.newLine();
            for (int i = 0; i < students.length(); i++) {
                JSONObject student = students.getJSONObject(i);
                bw.write(student.getInt("id") + "," + student.getString("name") + "," + student.getInt("age") + "," + student.getInt("marks"));
                bw.newLine();
            }
            System.out.println("JSON to CSV conversion completed.");
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void convertCsvToJson(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))) {
            JSONArray students = new JSONArray();
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                JSONObject student = new JSONObject();
                student.put("id", Integer.parseInt(data[0]));
                student.put("name", data[1]);
                student.put("age", Integer.parseInt(data[2]));
                student.put("marks", Integer.parseInt(data[3]));
                students.put(student);
            }
            bw.write(students.toString(4));
            System.out.println("CSV to JSON conversion completed.");
        } catch (IOException | JSONException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
