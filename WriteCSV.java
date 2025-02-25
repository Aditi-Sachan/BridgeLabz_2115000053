import java.io.*;

class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String[] employees = {
            "101,John Doe,HR,50000",
            "102,Jane Smith,IT,60000",
            "103,Emily Davis,Finance,55000",
            "104,Michael Brown,Marketing,52000",
            "105,David Wilson,Sales,58000"
        };
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String employee : employees) {
                bw.write(employee);
                bw.newLine();
            }
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
