import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        double height = input.nextDouble();
        double areaInSquareInches = 0.5 * base * height;
        double areaInSquareCentimeters = areaInSquareInches * 6.4516;
        System.out.println("The area of the triangle in square inches is " + areaInSquareInches + " and in square centimeters is " + areaInSquareCentimeters);
    }
}
