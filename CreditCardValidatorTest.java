import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.regex.*;

class CreditCardValidator {
    public boolean isValidCreditCard(String cardNumber) {
        String regex = "^(4[0-9]{15}|5[1-5][0-9]{14})$";
        return Pattern.matches(regex, cardNumber);
    }
}

class CreditCardValidatorTest {
    CreditCardValidator creditCardValidator;

    @BeforeEach
    void setUp() {
        creditCardValidator = new CreditCardValidator();
    }

    @Test
    void testValidVisaCard() {
        assertTrue(creditCardValidator.isValidCreditCard("4111111111111111"));
    }

    @Test
    void testValidMasterCard() {
        assertTrue(creditCardValidator.isValidCreditCard("5105105105105100"));
    }

    @Test
    void testInvalidCreditCard() {
        assertFalse(creditCardValidator.isValidCreditCard("1234567890123456"));
        assertFalse(creditCardValidator.isValidCreditCard("4111111111111"));
        assertFalse(creditCardValidator.isValidCreditCard("6011111111111117"));
    }
}
