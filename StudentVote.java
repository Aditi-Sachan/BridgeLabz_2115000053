
import java.util.Scanner;

public class StudentVote {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;
        }
        return age >= 18;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker voteChecker = new StudentVoteChecker();
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            System.out.print("Enter the age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        for (int i = 0; i < ages.length; i++) {
            boolean canVote = voteChecker.canStudentVote(ages[i]);
            System.out.println("Student " + (i + 1) + " can vote: " + canVote);
        }

        scanner.close();
    }
}

