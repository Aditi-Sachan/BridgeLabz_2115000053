import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class LinkExtractor {
    public List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/[a-zA-Z0-9._%+-]*)*").matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
}

class LinkTest {
    LinkExtractor linkExtractor;

    @BeforeEach
    void setUp() {
        linkExtractor = new LinkExtractor();
    }

    @Test
    void testExtractLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> expected = Arrays.asList("https://www.google.com", "http://example.org");
        assertEquals(expected, linkExtractor.extractLinks(text));
    }

    @Test
    void testNoLinks() {
        String text = "There are no links here.";
        assertTrue(linkExtractor.extractLinks(text).isEmpty());
    }
}
