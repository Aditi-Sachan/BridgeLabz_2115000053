import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String toJson() throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        Field[] fields = this.getClass().getDeclaredFields();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                String key = field.getAnnotation(JsonField.class).name();
                String value = field.get(this).toString();
                jsonMap.put(key, value);
            }
        }
        
        return jsonMap.toString().replace("=", ": ");
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Alice", 25);
        System.out.println(user.toJson());
    }
}
