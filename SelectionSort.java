import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(double[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] examScores = { 85.5, 72.0, 90.5, 60.0, 78.5, 88.0 };
        selectionSort(examScores);
        System.out.println(Arrays.toString(examScores));
    }
}
