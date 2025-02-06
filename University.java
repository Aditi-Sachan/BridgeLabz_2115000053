import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    Professor professor;
    List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    void enrollStudent(Student student) {
        students.add(student);
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName + ", Professor: " + professor.name);
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

class Professor {
    String name;
    List<Course> courses = new ArrayList<>();

    Professor(String name) {
        this.name = name;
    }

    void assignCourse(Course course) {
        courses.add(course);
        course.assignProfessor(this);
    }

    void displayCourses() {
        System.out.println(name + " teaches the following courses:");
        for (Course course : courses) {
            System.out.println(course.courseName);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    void displayCourses() {
        System.out.println(name + " is enrolled in the following courses:");
        for (Course course : courses) {
            System.out.println(course.courseName);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Johnson");

        Course course1 = new Course("Computer Science");
        Course course2 = new Course("Mathematics");

        professor1.assignCourse(course1);
        professor2.assignCourse(course2);

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student2.enrollCourse(course2);

        professor1.displayCourses();
        professor2.displayCourses();

        student1.displayCourses();
        student2.displayCourses();

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}
