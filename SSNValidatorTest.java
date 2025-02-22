import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.regex.*;

class SSNValidator {
    public boolean isValidSSN(String ssn) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(regex, ssn);
    }
}

class SSNValidatorTest {
    SSNValidator ssnValidator;

    @BeforeEach
    void setUp() {
        ssnValidator = new SSNValidator();
    }

    @Test
    void testValidSSN() {
        assertTrue(ssnValidator.isValidSSN("123-45-6789"));
    }

    @Test
    void testInvalidSSN() {
        assertFalse(ssnValidator.isValidSSN("123456789"));
        assertFalse(ssnValidator.isValidSSN("12-345-6789"));
        assertFalse(ssnValidator.isValidSSN("123-456-789"));
        assertFalse(ssnValidator.isValidSSN("abc-de-ghij"));
    }
}
