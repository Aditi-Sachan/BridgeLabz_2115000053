import java.util.*;

class SetOperations {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in Set1:");
        int n1 = scanner.nextInt();
        Set<Integer> set1 = new HashSet<>();
        System.out.println("Enter the elements of Set1:");
        for (int i = 0; i < n1; i++) {
            set1.add(scanner.nextInt());
        }
        
        System.out.println("Enter the number of elements in Set2:");
        int n2 = scanner.nextInt();
        Set<Integer> set2 = new HashSet<>();
        System.out.println("Enter the elements of Set2:");
        for (int i = 0; i < n2; i++) {
            set2.add(scanner.nextInt());
        }
        
        System.out.println("Union: " + union(set1, set2));
        System.out.println("Intersection: " + intersection(set1, set2));
    }
}
