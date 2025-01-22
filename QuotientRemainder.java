import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int quotient = number1 / number2;
        int reminder = number1 % number2;
        System.out.println("The Quotient is " + quotient + " and Reminder is " + reminder + " of two numbers " + number1 + " and " + number2);
    }
}

