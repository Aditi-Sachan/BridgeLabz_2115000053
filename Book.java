
public class Book {
    String title;
    String author;
    double price;

    public Book() {
        title = "Dune";
        author = "Frank Herbert";
        price = 250.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java Programming", "John Doe", 29.99);

        System.out.println("Book 1: " + book1.title + " by " + book1.author + " costs $" + book1.price);
        System.out.println("Book 2: " + book2.title + " by " + book2.author + " costs $" + book2.price);
    }
}




