public class AverageMarks {
    public static void main(String[] args) {
        int maths = 94;
        int physics = 95;
        int chemistry = 96;
        int totalMarks = maths + physics + chemistry;
        int subjects = 3;
        double average = (double) totalMarks / subjects;
        System.out.println("Sam's average mark in PCM is " + average);
    }
}
