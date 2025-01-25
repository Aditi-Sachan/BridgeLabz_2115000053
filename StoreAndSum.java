import java.util.Scanner;

public class StoreAndSum {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();
            if (input <= 0 || index == 10) {
                break;
            }
            numbers[index++] = input;
        }

        for (int i = 0; i < index; i++) {
            total += numbers[i];
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }

        System.out.println("Total: " + total);
        scanner.close();
    }
}
