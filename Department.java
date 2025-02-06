import java.util.ArrayList;
import java.util.List;

class Department {
    String departmentName;

    Department(String departmentName) {
        this.departmentName = departmentName;
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class University {
    String universityName;
    List<Department> departments = new ArrayList<>();
    List<Faculty> facultyMembers = new ArrayList<>();

    University(String universityName) {
        this.universityName = universityName;
    }

    void addDepartment(Department department) {
        departments.add(department);
    }

    void addFacultyMember(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    void deleteUniversity() {
        departments.clear();
    }

    void displayDepartments() {
        System.out.println("Departments in " + universityName + ":");
        for (Department department : departments) {
            System.out.println(department.departmentName);
        }
    }

    void displayFaculty() {
        System.out.println("Faculty members in " + universityName + ":");
        for (Faculty faculty : facultyMembers) {
            System.out.println(faculty.name);
        }
    }
}

class Main {
    public static void main(String[] args) {
        University university = new University("Tech University");

        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");

        university.addFacultyMember(faculty1);
        university.addFacultyMember(faculty2);

        Department csDepartment = new Department("Computer Science");
        Department eeDepartment = new Department("Electrical Engineering");

        university.addDepartment(csDepartment);
        university.addDepartment(eeDepartment);

        university.displayFaculty();
        university.displayDepartments();

        university.deleteUniversity();
        university.displayDepartments();
    }
}

