import java.util.Random;  
import java.util.Scanner;  

public class Students {  

    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        System.out.print("Enter the number of students: ");  
        int numberOfStudents = scanner.nextInt();  

        int[][] scores = generateRandomScores(numberOfStudents);  
        double[][] result = calculateResults(scores);  
        displayScorecard(result, scores);  
    }  

    public static int[][] generateRandomScores(int numStudents) {  
        Random random = new Random();  
        int[][] scores = new int[numStudents][3];  
        for (int i = 0; i < numStudents; i++) {  
            for (int j = 0; j < 3; j++) {  
                scores[i][j] = random.nextInt(100);  
            }  
        }  
        return scores;  
    }  

    public static double[][] calculateResults(int[][] scores) {  
        double[][] results = new double[scores.length][4];  
        for (int i = 0; i < scores.length; i++) {  
            int total = scores[i][0] + scores[i][1] + scores[i][2];  
            double average = total / 3.0;  
            double percentage = (total / 300.0) * 100;  
            results[i][0] = total;  
            results[i][1] = average;  
            results[i][2] = Math.round(percentage * 100.0) / 100.0;  
            results[i][3] = determineGrade(results[i][2]);  
        }  
        return results;  
    }  

    public static void displayScorecard(double[][] results, int[][] scores) {  
        System.out.println("Scorecard:");  
        System.out.println("Scores\tTotal\tAverage\tPercentage\tGrade");  
        for (int i = 0; i < results.length; i++) {  
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t");  
            System.out.printf("%.2f\t", results[i][2]);  
            System.out.println((char) results[i][3]);  
        }  
    }  

    public static char determineGrade(double percentage) {  
        if (percentage >= 80) return 'A';  
        else if (percentage >= 70) return 'B';  
        else if (percentage >= 60) return 'C';  
        else if (percentage >= 50) return 'D';  
        else if (percentage >= 40) return 'E';  
        else return 'R';  
    }  
}

