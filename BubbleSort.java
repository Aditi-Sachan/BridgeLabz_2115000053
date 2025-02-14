import java.util.Arrays;
public class BubbleSort {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] studentMarks = {85, 92, 78, 90, 88, 76, 95, 89};
        bubbleSort(studentMarks);
        System.out.println("Sorted Marks: " + Arrays.toString(studentMarks));
    }
}


