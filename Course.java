public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName;

    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " weeks, Fee: $" + fee);
    }

    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course course1 = new Course("Java Programming", 8, 299.99);
        Course course2 = new Course("Python Basics", 6, 199.99);

        Course.updateInstituteName("Tech Institute");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
