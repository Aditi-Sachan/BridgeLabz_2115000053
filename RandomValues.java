import java.util.Arrays;

public class RandomValues {

    public int[] generate4DigitRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 9000) + 1000;
        }
        return array;
    }

    public double[] findAverageMinMax(int[] numbers) {
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = (double) sum / numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        RandomValues stats = new RandomValues();
        int[] randomNumbers = stats.generate4DigitRandomArray(5);
        double[] results = stats.findAverageMinMax(randomNumbers);

        System.out.println("Random Numbers: " + Arrays.toString(randomNumbers));
        System.out.println("Average: " + results[0]);
        System.out.println("Minimum: " + results[1]);
        System.out.println("Maximum: " + results[2]);
    }
}

