import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String type;
    public CourseType(String type) { this.type = type; }
    public String getType() { return type; }
}

class ExamCourse extends CourseType {
    public ExamCourse() { super("Exam-Based"); }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() { super("Assignment-Based"); }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() { super("Research-Based"); }
}

class Course<T extends CourseType> {
    private String name;
    private T courseType;
    public Course(String name, T courseType) {
        this.name = name;
        this.courseType = courseType;
    }
    public String getName() { return name; }
    public T getCourseType() { return courseType; }
}

class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }
    public List<Course<? extends CourseType>> getCourses() { return courses; }
}

class University {
    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());
        Course<AssignmentCourse> history = new Course<>("History", new AssignmentCourse());
        Course<ResearchCourse> physics = new Course<>("Physics", new ResearchCourse());
        catalog.addCourse(math);
        catalog.addCourse(history);
        catalog.addCourse(physics);
        for (Course<? extends CourseType> course : catalog.getCourses()) {
            System.out.println(course.getName() + " - " + course.getCourseType().getType());
        }
    }
}
