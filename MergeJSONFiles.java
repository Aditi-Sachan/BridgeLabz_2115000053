import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

class MergeJSONFiles {
    public static void main(String[] args) {
        try {
            String content1 = new String(Files.readAllBytes(Paths.get("file1.json")));
            String content2 = new String(Files.readAllBytes(Paths.get("file2.json")));
            
            JSONObject json1 = new JSONObject(content1);
            JSONObject json2 = new JSONObject(content2);
            
            JSONObject mergedJson = new JSONObject(json1.toMap());
            mergedJson.putAll(json2.toMap());
            
            System.out.println(mergedJson.toString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
