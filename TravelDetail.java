import java.util.Scanner;

public class TravelDetail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your departure city: ");
        String fromCity = scanner.nextLine();
        System.out.print("Enter the city you are traveling via: ");
        String viaCity = scanner.nextLine();
        System.out.print("Enter your destination city: ");
        String toCity = scanner.nextLine();
        System.out.print("Enter the distance from your city to via city in miles: ");
        double fromToVia = scanner.nextDouble();
        System.out.print("Enter the distance from via city to destination city in miles: ");
        double viaToFinalCity = scanner.nextDouble();
        System.out.print("Enter the time taken for the journey in hours: ");
        double timeTaken = scanner.nextDouble();
        System.out.print("Enter the fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = scanner.nextDouble();

        double totalDistance = fromToVia + viaToFinalCity;
        double averageSpeed = totalDistance / timeTaken;
        double discountedFee = fee - (fee * discountPercent / 100);

        System.out.println("The results of Int Operations are " + totalDistance + ", " + averageSpeed + ", and " + discountedFee);
    }
}

