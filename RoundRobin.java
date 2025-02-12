import java.util.Scanner;

class Process {
    int id, burstTime, priority, remainingTime;
    Process next;
    
    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class CircularLinkedList {
    Process head = null, tail = null;
    
    void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }
    
    void removeProcess(int id) {
        if (head == null) return;
        Process temp = head, prev = null;
        do {
            if (temp.id == id) {
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    void display() {
        if (head == null) return;
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.id + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

class RoundRobinScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList processQueue = new CircularLinkedList();
        
        System.out.print("Enter time quantum: ");
        int timeQuantum = sc.nextInt();
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID, Burst Time, and Priority: ");
            int id = sc.nextInt(), burstTime = sc.nextInt(), priority = sc.nextInt();
            processQueue.addProcess(id, burstTime, priority);
        }
        
        int totalTime = 0, completed = 0;
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        
        Process current = processQueue.head;
        while (completed < n) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, current.remainingTime);
                totalTime += execTime;
                current.remainingTime -= execTime;
                if (current.remainingTime == 0) {
                    turnaroundTime[current.id - 1] = totalTime;
                    waitingTime[current.id - 1] = turnaroundTime[current.id - 1] - current.burstTime;
                    processQueue.removeProcess(current.id);
                    completed++;
                }
            }
            current = current.next;
            processQueue.display();
        }
        
        double avgWaitingTime = 0, avgTurnaroundTime = 0;
        for (int i = 0; i < n; i++) {
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }
        avgWaitingTime /= n;
        avgTurnaroundTime /= n;
        
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
        
        sc.close();
    }
}
