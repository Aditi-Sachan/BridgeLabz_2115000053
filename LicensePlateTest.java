import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class LicensePlateValidator {
    public boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\d{4}$");
    }
}

class LicensePlateTest {
    LicensePlateValidator licensePlateValidator;

    @BeforeEach
    void setUp() {
        licensePlateValidator = new LicensePlateValidator();
    }

    @Test
    void testValidLicensePlate() {
        assertTrue(licensePlateValidator.isValidLicensePlate("AB1234"));
    }

    @Test
    void testInvalidLicensePlateShortLetter() {
        assertFalse(licensePlateValidator.isValidLicensePlate("A1234"));
    }

    @Test
    void testInvalidLicensePlateExtraDigit() {
        assertFalse(licensePlateValidator.isValidLicensePlate("AB12345"));
    }

    @Test
    void testInvalidLicensePlateLowercase() {
        assertFalse(licensePlateValidator.isValidLicensePlate("ab1234"));
    }
}
