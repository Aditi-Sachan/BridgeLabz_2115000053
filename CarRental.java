public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Alice", "Toyota Corolla", 5);
        CarRental rental2 = new CarRental("Bob", "Honda Civic", 3);

        System.out.println("Rental 1 total cost: $" + rental1.calculateTotalCost());
        System.out.println("Rental 2 total cost: $" + rental2.calculateTotalCost());
    }
}

