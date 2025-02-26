import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

class FilterUsersByAge {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("users.json")));
            JSONArray jsonArray = new JSONArray(content);
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.optInt("age", 0) > 25) {
                    System.out.println(obj.toString(4));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
