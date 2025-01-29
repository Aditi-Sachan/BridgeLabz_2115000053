import java.util.Scanner;

public class RemoveCharacter {
    public static String removeChar(String str, char ch) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != ch) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        System.out.print("Enter the character to remove: ");
        char ch = scanner.next().charAt(0);
        scanner.close();

        System.out.println("Modified String: " + removeChar(str, ch));
    }
}

