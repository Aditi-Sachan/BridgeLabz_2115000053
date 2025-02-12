class Node {
    String text;
    Node prev, next;
    
    Node(String text) {
        this.text = text;
    }
}

class TextEditor {
    private Node head, tail, current;
    private int size = 0, capacity;
    
    TextEditor(int capacity) {
        this.capacity = capacity;
    }
    
    void addState(String text) {
        Node newNode = new Node(text);
        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        if (head == null) head = newNode;
        tail = newNode;
        size++;
        if (size > capacity) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }
    
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }
    
    void display() {
        System.out.println(current != null ? current.text : "No text available");
    }
}

class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.display();
        editor.undo();
        editor.display();
        editor.redo();
        editor.display();
    }
}
