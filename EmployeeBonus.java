import java.util.Random;

public class EmployeeBonus {

    public static void main(String[] args) {
        int[][] employeeData = generateEmployeeData();
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displaySalaryDetails(employeeData, updatedData);
    }

    public static int[][] generateEmployeeData() {
        Random random = new Random();
        int[][] data = new int[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 30000 + random.nextInt(70000);
            data[i][1] = random.nextInt(11);
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(int[][] employeeData) {
        double[][] updatedData = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double bonusPercentage = employeeData[i][1] > 5 ? 0.05 : 0.02;
            double bonus = employeeData[i][0] * bonusPercentage;
            updatedData[i][0] = employeeData[i][0] + bonus;
            updatedData[i][1] = bonus;
        }
        return updatedData;
    }

    public static void displaySalaryDetails(int[][] employeeData, double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        System.out.printf("%10s %10s %10s %10s %10s\n", "Emp ID", "Old Salary", "Years", "Bonus", "New Salary");
        for (int i = 0; i < 10; i++) {
            totalOldSalary += employeeData[i][0];
            totalNewSalary += updatedData[i][0];
            totalBonus += updatedData[i][1];
            System.out.printf("%10d %10d %10d %10.2f %10.2f\n", i + 1, employeeData[i][0], employeeData[i][1], updatedData[i][1], updatedData[i][0]);
        }
        System.out.printf("%10s %10.2f %10s %10.2f %10.2f\n", "Total", totalOldSalary, "", totalBonus, totalNewSalary);
    }
}
