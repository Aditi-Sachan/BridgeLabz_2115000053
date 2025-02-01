
public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public LibraryBook(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    public boolean borrowBook() {
        if (availability) {
            availability = false;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Java ", "John Doe", 29.99, true);
        LibraryBook book2 = new LibraryBook("Python", "Jane Doe", 19.99, false);

        System.out.println("Book 1 borrow status: " + book1.borrowBook());
        System.out.println("Book 2 borrow status: " + book2.borrowBook());
    }
}

