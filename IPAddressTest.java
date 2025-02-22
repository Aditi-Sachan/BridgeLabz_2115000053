import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.regex.*;

class IPAddressValidator {
    public boolean isValidIPAddress(String ip) {
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                       "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                       "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\." +
                       "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        return Pattern.matches(regex, ip);
    }
}

class IPAddressTest {
    IPAddressValidator ipAddressValidator;

    @BeforeEach
    void setUp() {
        ipAddressValidator = new IPAddressValidator();
    }

    @Test
    void testValidIPAddresses() {
        assertTrue(ipAddressValidator.isValidIPAddress("192.168.1.1"));
        assertTrue(ipAddressValidator.isValidIPAddress("255.255.255.255"));
        assertTrue(ipAddressValidator.isValidIPAddress("0.0.0.0"));
    }

    @Test
    void testInvalidIPAddresses() {
        assertFalse(ipAddressValidator.isValidIPAddress("256.256.256.256"));
        assertFalse(ipAddressValidator.isValidIPAddress("192.168.1"));
        assertFalse(ipAddressValidator.isValidIPAddress("192.168.1.999"));
        assertFalse(ipAddressValidator.isValidIPAddress("abc.def.ghi.jkl"));
    }
}
