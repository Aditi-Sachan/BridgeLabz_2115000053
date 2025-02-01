public class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee employee = new Employee(101, "IT", 50000.00);
        System.out.println("Employee ID: " + employee.employeeID + ", Department: " + employee.department + ", Salary: $" + employee.getSalary());
        employee.setSalary(55000.00);
        System.out.println("Updated Salary: $" + employee.getSalary());
    }
}

class Manager extends Employee {
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID + ", Department: " + department);
    }
}
