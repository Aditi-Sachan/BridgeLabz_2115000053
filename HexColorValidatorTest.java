import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


class HexColorValidator {
    public boolean isValidHexColor(String color) {
        return color.matches("^#[A-Fa-f0-9]{6}$");
    }
}


class HexColorValidatorTest {
    HexColorValidator hexColorValidator;


    @BeforeEach
    void setUp() {
        hexColorValidator = new HexColorValidator();
    }


    @Test
    void testValidHexColorUppercase() {
        assertTrue(hexColorValidator.isValidHexColor("#FFA500"));
    }


    @Test
    void testValidHexColorLowercase() {
        assertTrue(hexColorValidator.isValidHexColor("#ff4500"));
    }


    @Test
    void testInvalidHexColorTooShort() {
        assertFalse(hexColorValidator.isValidHexColor("#123"));
    }


    @Test
    void testInvalidHexColorNoHash() {
        assertFalse(hexColorValidator.isValidHexColor("FFA500"));
    }
}
