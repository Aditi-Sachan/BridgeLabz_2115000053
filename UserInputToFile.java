import java.io.*;
class UserInputToFile {
    public static void main(String[] args) {
        String outputFile = "info.txt";
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(outputFile)) {
            
            System.out.print("Enter your name: ");
            String name = reader.readLine();
            
            System.out.print("Enter your age: ");
            String age = reader.readLine();
            
            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();
            
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");
            
            System.out.println("Information saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
