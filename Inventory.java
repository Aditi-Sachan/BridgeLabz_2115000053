import java.util.Scanner;

class Item {
    String name;
    int id, quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    void addItem(String name, int id, int quantity, double price, int position) {
        Item newItem = new Item(name, id, quantity, price);
        if (position == 0 || head == null) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        for (int i = 0; temp.next != null && i < position - 1; i++) temp = temp.next;
        newItem.next = temp.next;
        temp.next = newItem;
    }

    void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    void updateQuantity(int id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    Item searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    double totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        return total;
    }

    void sortByName() {
        head = mergeSort(head, true);
    }

    void sortByPrice() {
        head = mergeSort(head, false);
    }

    Item mergeSort(Item head, boolean sortByName) {
        if (head == null || head.next == null) return head;
        Item mid = getMiddle(head);
        Item nextOfMid = mid.next;
        mid.next = null;
        Item left = mergeSort(head, sortByName);
        Item right = mergeSort(nextOfMid, sortByName);
        return merge(left, right, sortByName);
    }

    Item merge(Item left, Item right, boolean sortByName) {
        if (left == null) return right;
        if (right == null) return left;
        if ((sortByName && left.name.compareToIgnoreCase(right.name) < 0) || (!sortByName && left.price < right.price)) {
            left.next = merge(left.next, right, sortByName);
            return left;
        } else {
            right.next = merge(left, right.next, sortByName);
            return right;
        }
    }

    Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " " + temp.id + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }
}

class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        inventory.addItem("Item1", 101, 10, 5.5, 0);
        inventory.addItem("Item2", 102, 20, 3.0, 1);
        inventory.addItem("Item3", 103, 15, 7.2, 2);
        inventory.display();
        inventory.removeItem(102);
        inventory.display();
        inventory.updateQuantity(101, 25);
        System.out.println("Total Inventory Value: " + inventory.totalInventoryValue());
        inventory.sortByName();
        inventory.display();
        scanner.close();
    }
}


















