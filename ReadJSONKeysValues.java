import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

class ReadJSONKeysValues {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONObject jsonObject = new JSONObject(content);
            
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                System.out.println(key + ": " + jsonObject.get(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
