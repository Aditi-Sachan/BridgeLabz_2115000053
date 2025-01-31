import java.util.Scanner;

class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Enter employee name: ");
        employee.name = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        employee.id = scanner.nextInt();

        System.out.print("Enter employee salary: ");
        employee.salary = scanner.nextDouble();

        employee.displayDetails();
        scanner.close();
    }
}
