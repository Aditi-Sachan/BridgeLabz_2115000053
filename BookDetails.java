import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();

        System.out.print("Enter book title: ");
        book.title = scanner.nextLine();

        System.out.print("Enter author name: ");
        book.author = scanner.nextLine();

        System.out.print("Enter book price: ");
        book.price = scanner.nextDouble();

        book.displayDetails();
        scanner.close();
    }
}
