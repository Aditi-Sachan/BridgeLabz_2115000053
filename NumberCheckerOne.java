import java.util.Arrays;

public class NumberCheckerOne {

    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }

    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }

    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversedDigits = reverseArray(digits);
        return compareArrays(digits, reversedDigits);
    }

    public static boolean isDuckNumber(int number) {
        if (number == 0) return false;
        int[] digits = getDigitsArray(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 12321;
        int number2 = 1023;

        System.out.println("Count of digits: " + countDigits(number));

        int[] digitsArray = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digitsArray));

        int[] reversedArray = reverseArray(digitsArray);
        System.out.println("Reversed digits array: " + Arrays.toString(reversedArray));

        System.out.println("Arrays are equal: " + compareArrays(digitsArray, reversedArray));

        System.out.println("Is palindrome: " + isPalindrome(number));

        System.out.println("Is duck number: " + isDuckNumber(number2));
    }
}
