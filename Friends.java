import java.util.Scanner;

public class Friends {

    public int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    public int findTallest(int[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FriendsComparison comparison = new FriendsComparison();

        int[] ages = new int[3];
        int[] heights = new int[3];
        String[] names = {"Amar", "Akbar", "Anthony"};

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter the height of " + names[i] + " in cm: ");
            heights[i] = scanner.nextInt();
        }

        int youngestIndex = comparison.findYoungest(ages);
        int tallestIndex = comparison.findTallest(heights);

        System.out.println("The youngest friend is " + names[youngestIndex] + ".");
        System.out.println("The tallest friend is " + names[tallestIndex] + ".");

        scanner.close();
    }
}
