import java.io.*;

class StudentDataStream {
    public static void main(String[] args) {
        String fileName = "students.dat";
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeInt(101);
            dos.writeUTF("Alice");
            dos.writeDouble(3.8);
            
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(3.6);
            
            System.out.println("Student details stored successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll No: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
