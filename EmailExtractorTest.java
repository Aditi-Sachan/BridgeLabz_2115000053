import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class EmailExtractor {
    public List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,6}").matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
}

class EmailExtractorTest {
    EmailExtractor emailExtractor;

    @BeforeEach
    void setUp() {
        emailExtractor = new EmailExtractor();
    }

    @Test
    void testExtractEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> expected = Arrays.asList("support@example.com", "info@company.org");
        assertEquals(expected, emailExtractor.extractEmails(text));
    }

    @Test
    void testNoEmails() {
        String text = "No emails here!";
        assertTrue(emailExtractor.extractEmails(text).isEmpty());
    }
}
