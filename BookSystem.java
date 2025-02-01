public class BookSystem {
    public String ISBN;
    protected String title;
    private String author;

    public BookSystem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        BookSystem book = new BookSystem("123-456-789", "Java Programming", "John Doe");
        System.out.println("ISBN: " + book.ISBN + ", Title: " + book.title + ", Author: " + book.getAuthor());
        book.setAuthor("Jane Doe");
        System.out.println("Updated Author: " + book.getAuthor());
    }
}

class EBook extends BookSystem {
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title);
    }
}
