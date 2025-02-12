import java.time.LocalDateTime;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    Ticket(int ticketID, String customerName, String movieName, int seatNumber) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;

    public void addTicket(int ticketID, String customerName, String movieName, int seatNumber) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
    }

    public void removeTicket(int ticketID) {
        if (last == null) return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketID == ticketID) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) last = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    public void displayTickets() {
        if (last == null) return;
        Ticket current = last.next;
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != last.next);
    }

    public void searchTicket(String query) {
        if (last == null) return;
        Ticket current = last.next;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket ID: " + current.ticketID + ", Customer: " + current.customerName + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber + ", Time: " + current.bookingTime);
            }
            current = current.next;
        } while (current != last.next);
    }

    public int countTickets() {
        if (last == null) return 0;
        int count = 0;
        Ticket current = last.next;
        do {
            count++;
            current = current.next;
        } while (current != last.next);
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(101, "Alice", "Inception", 5);
        system.addTicket(102, "Bob", "Interstellar", 10);
        system.addTicket(103, "Charlie", "Inception", 15);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
        system.searchTicket("Inception");
        system.removeTicket(102);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}
