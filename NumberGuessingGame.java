import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String feedback;
        int low = 1, high = 100;
        boolean correct = false;
        
        while (!correct) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            feedback = scanner.nextLine().toLowerCase();
            
            correct = processFeedback(feedback);
            
            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }
        }
        System.out.println("Yay! The computer guessed your number!");
    }

    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static boolean processFeedback(String feedback) {
        return feedback.equals("correct");
    }
}
