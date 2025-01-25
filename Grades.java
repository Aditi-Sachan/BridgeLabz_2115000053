import java.util.Scanner;  

public class Grades {  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter the number of students: ");  
        int n = sc.nextInt();  
        double[] percentages = new double[n];  
        String[] grades = new String[n];  
        int[][] marks = new int[n][3];  

        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < 3; j++) {  
                do {  
                    System.out.print("Enter marks for student " + (i + 1) + " in subject " + (j + 1) + ": ");  
                    marks[i][j] = sc.nextInt();  
                    if (marks[i][j] < 0) {  
                        System.out.println("Please enter positive values.");  
                    }  
                } while (marks[i][j] < 0);  
            }  
            double total = marks[i][0] + marks[i][1] + marks[i][2];  
            percentages[i] = (total / 300) * 100;  
            if (percentages[i] >= 80) {  
                grades[i] = "A";  
            } else if (percentages[i] >= 70) {  
                grades[i] = "B";  
            } else if (percentages[i] >= 60) {  
                grades[i] = "C";  
            } else if (percentages[i] >= 50) {  
                grades[i] = "D";  
            } else if (percentages[i] >= 40) {  
                grades[i] = "E";  
            } else {  
                grades[i] = "R";  
            }  
        }  

        System.out.println("Marks\tPercentage\tGrade");  
        for (int i = 0; i < n; i++) {  
            System.out.print(marks[i][0] + ", " + marks[i][1] + ", " + marks[i][2] + "\t");  
            System.out.print(percentages[i] + "\t\t" + grades[i]);  
            System.out.println();  
        }  
    }  
}
