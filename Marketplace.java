import java.util.ArrayList;
import java.util.List;

abstract class Category {
    private String name;
    public Category(String name) { this.name = name; }
    public String getName() { return name; }
}

class Book extends Category {
    public Book() { super("Books"); }
}

class Clothing extends Category {
    public Clothing() { super("Clothing"); }
}

class Gadget extends Category {
    public Gadget() { super("Gadgets"); }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }
}

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();
    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }
    public List<Product<? extends Category>> getProducts() { return products; }
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double newPrice = product.getPrice() - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);
    }
}

class Marketplace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Product<Book> book = new Product<>("Java Programming", 50.0, new Book());
        Product<Clothing> shirt = new Product<>("T-Shirt", 20.0, new Clothing());
        Product<Gadget> phone = new Product<>("Smartphone", 500.0, new Gadget());
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        Catalog.applyDiscount(book, 10);
        Catalog.applyDiscount(shirt, 15);
        Catalog.applyDiscount(phone, 5);
        for (Product<? extends Category> product : catalog.getProducts()) {
            System.out.println(product.getName() + " - " + product.getCategory().getName() + ": $" + product.getPrice());
        }
    }
}
