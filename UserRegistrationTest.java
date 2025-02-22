import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}

class UserRegistrationTest {
    UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("testUser", "test@example.com", "Password1"));
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "test@example.com", "Password1"));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("testUser", "invalid-email", "Password1"));
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("testUser", "test@example.com", "short"));
    }
}
