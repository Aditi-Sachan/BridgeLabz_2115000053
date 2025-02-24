import java.lang.reflect.*;

class ClassInspector {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "java.util.ArrayList";
        Class<?> cls = Class.forName(className);

        System.out.println("Class: " + cls.getName());

        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(field);
        }

        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(constructor);
        }

        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
