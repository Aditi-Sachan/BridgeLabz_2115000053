import org.json.JSONObject;

class MergeJSON {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("name", "John Doe");
        json1.put("email", "john.doe@example.com");
        
        JSONObject json2 = new JSONObject();
        json2.put("age", 30);
        json2.put("city", "New York");
        
        JSONObject mergedJson = new JSONObject(json1.toMap());
        mergedJson.putAll(json2.toMap());
        
        System.out.println(mergedJson.toString(4));
    }
}
