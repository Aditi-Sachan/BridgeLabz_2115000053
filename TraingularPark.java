
import java.util.Scanner;

public class TriangularPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side 1 of the triangular park (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter side 2 of the triangular park (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter side 3 of the triangular park (in meters): ");
        double side3 = scanner.nextDouble();

        double perimeter = calculatePerimeter(side1, side2, side3);
        int rounds = calculateRounds(5000, perimeter);

        System.out.println("The athlete needs to complete " + rounds + " rounds to finish a 5 km run.");

        scanner.close();
    }

    public static double calculatePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    public static int calculateRounds(double distance, double perimeter) {
        return (int) Math.ceil(distance / perimeter);
    }
}

