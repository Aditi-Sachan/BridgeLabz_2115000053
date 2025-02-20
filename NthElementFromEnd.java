import java.util.*;

class NthElementFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) {
            if (!first.hasNext()) return null;
            first.next();
        }
        while (first.hasNext()) {
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        LinkedList<String> list = new LinkedList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.next());
        }
        System.out.println("Enter the value of N:");
        int position = scanner.nextInt();
        String result = findNthFromEnd(list, position);
        System.out.println(result != null ? result : "Invalid position");
    }
}
