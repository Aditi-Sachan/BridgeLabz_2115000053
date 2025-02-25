import java.io.*;
import java.sql.*;

class GenerateCSVFromDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "password";
        String query = "SELECT id, name, department, salary FROM employees";
        String outputFile = "employees_report.csv";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("Employee ID,Name,Department,Salary");
            bw.newLine();
            while (rs.next()) {
                String record = rs.getInt("id") + "," + rs.getString("name") + "," + rs.getString("department") + "," + rs.getDouble("salary");
                bw.write(record);
                bw.newLine();
            }
            System.out.println("CSV report generated successfully.");
        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
