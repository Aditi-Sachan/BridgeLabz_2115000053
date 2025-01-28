import java.util.Scanner;

public class NaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number. Exiting.");
            return;
        }

        int recursiveSum = findSumRecursive(n);
        int formulaSum = findSumFormula(n);

        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both methods yield the correct result.");
        } else {
            System.out.println("The results do not match.");
        }

        scanner.close();
    }

    public static int findSumRecursive(int n) {
        if (n == 1) {
            return 1;
        }
        return n + findSumRecursive(n - 1);
    }

    public static int findSumFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}

