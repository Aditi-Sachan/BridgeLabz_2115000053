import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "DEFAULT_KEY";

    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Original API_KEY: " + field.get(null));

        field.set(null, "NEW_API_KEY");
        System.out.println("Modified API_KEY: " + field.get(null));
    }
}
