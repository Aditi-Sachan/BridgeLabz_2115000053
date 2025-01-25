import java.util.Scanner;  

public class BMI {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        
        System.out.print("Enter the number of persons: ");  
        int n = scanner.nextInt();  
        
        double[] weights = new double[n];  
        double[] heights = new double[n];  
        double[] bmis = new double[n];  
        String[] statuses = new String[n];  
        
        for (int i = 0; i < n; i++) {  
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");  
            weights[i] = scanner.nextDouble();  
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");  
            heights[i] = scanner.nextDouble();  
            bmis[i] = weights[i] / (heights[i] * heights[i]);  
            
            if (bmis[i] <= 18.4) {  
                statuses[i] = "Underweight";  
            } else if (bmis[i] <= 24.9) {  
                statuses[i] = "Normal";  
            } else if (bmis[i] <= 39.9) {  
                statuses[i] = "Overweight";  
            } else {  
                statuses[i] = "Obese";  
            }  
        }  
        
        System.out.println("Height (m) | Weight (kg) | BMI   | Status");  
        for (int i = 0; i < n; i++) {  
            System.out.printf("%.2f        | %.2f       | %.2f | %s%n", heights[i], weights[i], bmis[i], statuses[i]);  
        }  
        
        scanner.close();  
    }  
}
