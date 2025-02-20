import java.util.*;

class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;
        List<T> rotated = new ArrayList<>(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        System.out.println("Enter the number of positions to rotate:");
        int positions = scanner.nextInt();
        rotateList(list, positions);
        System.out.println(list);
    }
}
