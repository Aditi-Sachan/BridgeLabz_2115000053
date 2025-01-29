import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentCharacter {
    public static char findMostFrequentChar(String str) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char maxChar = str.charAt(0);
        int maxCount = 0;

        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            if (freqMap.get(c) > maxCount) {
                maxCount = freqMap.get(c);
                maxChar = c;
            }
        }
        return maxChar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println("Most Frequent Character: '" + findMostFrequentChar(input) + "'");
    }
}

