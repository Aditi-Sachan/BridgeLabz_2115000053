import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    private static final String currentUserRole = "USER";

    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    public static void main(String[] args) throws Exception {
        AccessControl accessControl = new AccessControl();
        Method method = AccessControl.class.getMethod("adminTask");

        if (method.isAnnotationPresent(RoleAllowed.class)) {
            String requiredRole = method.getAnnotation(RoleAllowed.class).value();
            if (currentUserRole.equals(requiredRole)) {
                method.invoke(accessControl);
            } else {
                System.out.println("Access Denied!");
            }
        }
    }
}
