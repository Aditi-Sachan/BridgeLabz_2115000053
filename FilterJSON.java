import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

class FilterJSON {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("data.json")));
            JSONArray jsonArray = new JSONArray(content);
            JSONArray filteredArray = new JSONArray();
            
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                if (obj.optInt("age", 0) > 25) {
                    filteredArray.put(obj);
                }
            }
            
            System.out.println(filteredArray.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
