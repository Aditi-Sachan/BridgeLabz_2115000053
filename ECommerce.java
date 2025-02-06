import java.util.ArrayList;
import java.util.List;

class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}

class Order {
    int orderId;
    List<Product> products = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Product product : products) {
            System.out.println(product.productName + " - $" + product.price);
        }
    }
}

class Customer {
    String name;
    List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void displayOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 1200.50);
        Product product2 = new Product("Smartphone", 800.99);
        Product product3 = new Product("Headphones", 150.75);

        Order order1 = new Order(101);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102);
        order2.addProduct(product3);

        Customer customer = new Customer("John Doe");
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        customer.displayOrders();
    }
}

