import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

class ReadJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);
            
            String name = jsonObject.optString("name");
            String email = jsonObject.optString("email");
            
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
