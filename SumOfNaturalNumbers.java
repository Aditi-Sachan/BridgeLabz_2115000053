
import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("The number is not a natural number.");
            return;
        }
        
        int sumFormula = n * (n + 1) / 2;
        int sumWhile = 0;
        int counter = 1;

        while (counter <= n) {
            sumWhile += counter;
            counter++;
        }

        System.out.println("Sum using formula: " + sumFormula);
        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Both computations are " + (sumFormula == sumWhile ? "correct." : "incorrect."));
    }
}

