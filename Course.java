import java.util.ArrayList;
import java.util.List;

class Course {
    String courseName;
    List<Student> students = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void enrollStudent(Student student) {
        students.add(student);
    }

    void displayStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollInCourse(Course course) {
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

class School {
    String schoolName;
    List<Student> students = new ArrayList<>();

    School(String schoolName) {
        this.schoolName = schoolName;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student student : students) {
            System.out.println(student.name);
        }
    }
}

class Main {
    public static void main(String[] args) {
        School school = new School("Green Valley High");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        school.addStudent(student1);
        school.addStudent(student2);

        Course math = new Course("Math");
        Course science = new Course("Science");

        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        school.displayStudents();
        student1.displayCourses();
        student2.displayCourses();
        math.displayStudents();
        science.displayStudents();
    }
}

