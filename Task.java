import java.util.Scanner;

class Task {
    int id, priority;
    String name, dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    public void addTaskAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            newTask.next = head;
            temp.next = newTask;
            head = newTask;
        }
    }

    public void addTaskAtEnd(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void addTaskAtPosition(int id, String name, int priority, String dueDate, int position) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (position <= 0 || head == null) {
            addTaskAtBeginning(id, name, priority, dueDate);
            return;
        }
        Task temp = head;
        for (int i = 0; temp.next != head && i < position - 1; i++) temp = temp.next;
        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeTaskById(int id) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head) {
                    Task last = head;
                    while (last.next != head) last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (current == null) current = head;
        if (current != null) {
            System.out.println(current.id + " " + current.name + " " + current.priority + " " + current.dueDate);
            current = current.next;
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.id + " " + temp.name + " " + temp.priority + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority)
                System.out.println(temp.id + " " + temp.name + " " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Task at Beginning\n2. Add Task at End\n3. Add Task at Position\n4. Remove Task by ID\n5. View Current Task\n6. Display All Tasks\n7. Search by Priority\n8. Exit");
            int choice = scanner.nextInt();
            if (choice == 8) break;
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.println("Enter Task ID, Name, Priority, Due Date:");
                int id = scanner.nextInt();
                String name = scanner.next();
                int priority = scanner.nextInt();
                String dueDate = scanner.next();
                if (choice == 1) scheduler.addTaskAtBeginning(id, name, priority, dueDate);
                else if (choice == 2) scheduler.addTaskAtEnd(id, name, priority, dueDate);
                else {
                    System.out.println("Enter position:");
                    int pos = scanner.nextInt();
                    scheduler.addTaskAtPosition(id, name, priority, dueDate, pos);
                }
            } else if (choice == 4) {
                System.out.println("Enter Task ID to remove:");
                int id = scanner.nextInt();
                scheduler.removeTaskById(id);
            } else if (choice == 5) scheduler.viewCurrentTask();
            else if (choice == 6) scheduler.displayTasks();
            else if (choice == 7) {
                System.out.println("Enter Priority to search:");
                int priority = scanner.nextInt();
                scheduler.searchByPriority(priority);
            }
        }
        scanner.close();
    }
}

