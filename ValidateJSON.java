import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

class ValidateJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("data.json"));
            
            if (jsonNode.has("name") && jsonNode.has("email")) {
                System.out.println("Valid JSON structure.");
            } else {
                System.out.println("Invalid JSON structure.");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON format.");
        }
    }
}
