import java.util.Scanner;  

public class BMICalculator {  
    public static void main(String[] args) {  
        double[][] data = new double[10][3];  
        String[] status = new String[10];  
        Scanner scanner = new Scanner(System.in);  

        for (int i = 0; i < 10; i++) {  
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");  
            data[i][0] = scanner.nextDouble();  
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");  
            data[i][1] = scanner.nextDouble();  
        }  

        calculateBMI(data);  
        calculateStatus(data, status);  
        displayResults(data, status);  
    }  

    public static void calculateBMI(double[][] data) {  
        for (int i = 0; i < 10; i++) {  
            double heightInMeters = data[i][1] / 100;  
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);  
        }  
    }  

    public static void calculateStatus(double[][] data, String[] status) {  
        for (int i = 0; i < 10; i++) {  
            if (data[i][2] <= 18.4) {  
                status[i] = "Underweight";  
            } else if (data[i][2] <= 24.9) {  
                status[i] = "Normal";  
            } else if (data[i][2] <= 39.9) {  
                status[i] = "Overweight";  
            } else {  
                status[i] = "Obese";  
            }  
        }  
    }  

    public static void displayResults(double[][] data, String[] status) {  
        System.out.println("Weight(kg) | Height(cm) | BMI     | Status");  
        for (int i = 0; i < 10; i++) {  
            System.out.printf("%.2f      | %.2f      | %.2f   | %s%n", data[i][0], data[i][1], data[i][2], status[i]);  
        }  
    }  
}

