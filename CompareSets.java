import java.util.*;

class CompareSets {
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
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
        
        System.out.println(areSetsEqual(set1, set2));
    }
}
