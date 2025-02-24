import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Application {
    @ImportantMethod
    public void criticalProcess() {
        System.out.println("Executing critical process...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void regularProcess() {
        System.out.println("Executing regular process...");
    }

    public static void main(String[] args) {
        Method[] methods = Application.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}
