import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class UsernameValidator {
    public boolean isValidUsername(String username) {
        return username.matches("^[A-Za-z][A-Za-z0-9_]{4,14}$");
    }
}

class UsernameValidatorTest {
    UsernameValidator usernameValidator;

    @BeforeEach
    void setUp() {
        usernameValidator = new UsernameValidator();
    }

    @Test
    void testValidUsername() {
        assertTrue(usernameValidator.isValidUsername("user_123"));
    }

    @Test
    void testUsernameStartsWithNumber() {
        assertFalse(usernameValidator.isValidUsername("123user"));
    }

    @Test
    void testUsernameTooShort() {
        assertFalse(usernameValidator.isValidUsername("us"));
    }
}
