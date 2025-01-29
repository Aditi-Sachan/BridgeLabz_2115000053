import java.util.Scanner;

class FactorialCalculator {
    public static void main(String[] args) {
        int number = getInput();
        long result = calculateFactorial(number);
        displayResult(number, result);
    }

    static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();
        return num;
    }

    static long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }

    static void displayResult(int num, long result) {
        System.out.println("Factorial of " + num + " is: " + result);
    }
}

