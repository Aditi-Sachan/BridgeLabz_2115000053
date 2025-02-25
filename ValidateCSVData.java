import java.io.*;
import java.util.regex.*;

class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\d{10}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Matcher emailMatcher = emailPattern.matcher(data[3]);
                Matcher phoneMatcher = phonePattern.matcher(data[4]);
                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email: " + data[3] + " in row: " + line);
                }
                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number: " + data[4] + " in row: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
