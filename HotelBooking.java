
public class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        guestName = "Aditi Sachan";
        roomType = "Standard";
        nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking();
        HotelBooking booking2 = new HotelBooking("Alice", "Deluxe", 3);
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Booking 1: " + booking1.guestName + " in " + booking1.roomType + " for " + booking1.nights + " nights.");
        System.out.println("Booking 2: " + booking2.guestName + " in " + booking2.roomType + " for " + booking2.nights + " nights.");
        System.out.println("Booking 3 (copy of booking2): " + booking3.guestName + " in " + booking3.roomType + " for " + booking3.nights + " nights.");
    }
}

