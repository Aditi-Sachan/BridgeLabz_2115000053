import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class PasswordValidator {
    public boolean isValid(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*");
    }
}

class PasswordTest {
    PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.isValid("StrongPass1"));
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(passwordValidator.isValid("Short1"));
    }

    @Test
    void testPasswordMissingUppercase() {
        assertFalse(passwordValidator.isValid("weakpassword1"));
    }

    @Test
    void testPasswordMissingDigit() {
        assertFalse(passwordValidator.isValid("WeakPassword"));
    }
}
