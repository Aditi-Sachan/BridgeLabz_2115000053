
import java.util.Arrays;

public class FootballTeam {

    public int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    public int findSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    public double findMean(int[] heights) {
        return (double) findSum(heights) / heights.length;
    }

    public int findShortest(int[] heights) {
        int shortest = heights[0];
        for (int height : heights) {
            shortest = Math.min(shortest, height);
        }
        return shortest;
    }

    public int findTallest(int[] heights) {
        int tallest = heights[0];
        for (int height : heights) {
            tallest = Math.max(tallest, height);
        }
        return tallest;
    }

    public static void main(String[] args) {
        FootballTeam stats = new FootballTeam();
        int[] heights = stats.generateHeights();
        int sum = stats.findSum(heights);
        double mean = stats.findMean(heights);
        int shortest = stats.findShortest(heights);
        int tallest = stats.findTallest(heights);

        System.out.println("Heights: " + Arrays.toString(heights));
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);
        System.out.println("Shortest: " + shortest);
        System.out.println("Tallest: " + tallest);
    }
}

