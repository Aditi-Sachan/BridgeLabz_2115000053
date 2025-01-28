import java.util.*;

public class NumberCheckerThree {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int findGreatestFactor(int number) {
        int[] factors = findFactors(number);
        return factors[factors.length - 2]; // Excluding the number itself
    }

    public static int findSumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static long findProductOfFactors(int number) {
        int[] factors = findFactors(number);
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static long findProductOfCubeOfFactors(int number) {
        int[] factors = findFactors(number);
        long product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = findSumOfFactors(number) - number;
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = findSumOfFactors(number) - number;
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = findSumOfFactors(number) - number;
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == originalNumber;
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 28;

        System.out.println("Factors: " + Arrays.toString(findFactors(number)));
        System.out.println("Greatest Factor: " + findGreatestFactor(number));
        System.out.println("Sum of Factors: " + findSumOfFactors(number));
        System.out.println("Product of Factors: " + findProductOfFactors(number));
        System.out.println("Product of Cube of Factors: " + findProductOfCubeOfFactors(number));
        System.out.println("Is Perfect Number: " + isPerfectNumber(number));
        System.out.println("Is Abundant Number: " + isAbundantNumber(number));
        System.out.println("Is Deficient Number: " + isDeficientNumber(number));
        System.out.println("Is Strong Number: " + isStrongNumber(number));
    }
}
