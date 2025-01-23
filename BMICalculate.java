import java.util.Scanner;  

public class BMICalculate {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        double weight = scanner.nextDouble();  
        double heightCm = scanner.nextDouble();  
        double heightM = heightCm / 100;  
        double bmi = weight / (heightM * heightM);  
        
        String status;  
        if (bmi <= 18.4) {  
            status = "Underweight";  
        } else if (bmi <= 24.9) {  
            status = "Normal";  
        } else if (bmi <= 39.9) {  
            status = "Overweight";  
        } else {  
            status = "Obese";  
        }  
        
        System.out.printf("BMI: %.2f\nStatus: %s\n", bmi, status);  
    }  
}

