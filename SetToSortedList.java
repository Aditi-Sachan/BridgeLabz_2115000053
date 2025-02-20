import java.util.*;

class SetToSortedList {
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the Set:");
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        System.out.println("Enter the elements of the Set:");
        for (int i = 0; i < n; i++) {
            set.add(scanner.nextInt());
        }
        
        System.out.println("Sorted List: " + convertToSortedList(set));
    }
}

