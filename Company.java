import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void listEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName());
        }
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department department : departments) {
            if (departmentName.equals(departmentName)) {
                department.addEmployee(employeeName);
            }
        }
    }

    public void listDepartments() {
        System.out.println("Company: " + name);
        for (Department department : departments) {
            department.listEmployees();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Company company = new Company("Tech Corp");
        company.addDepartment("Engineering");
        company.addDepartment("HR");
        
        company.addEmployeeToDepartment("Engineering", "Alice");
        company.addEmployeeToDepartment("HR", "Bob");
        
        company.listDepartments();
    }
}
