import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;

class BadWordFilter {
    private static final List<String> BAD_WORDS = Arrays.asList("damn", "stupid");

    public String censorBadWords(String text) {
        for (String badWord : BAD_WORDS) {
            text = text.replaceAll("\\b" + badWord + "\\b", "****");
        }
        return text;
    }
}

class BadWordFilterTest {
    BadWordFilter badWordFilter;

    @BeforeEach
    void setUp() {
        badWordFilter = new BadWordFilter();
    }

    @Test
    void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        String expected = "This is a **** bad example with some **** words.";
        assertEquals(expected, badWordFilter.censorBadWords(input));
    }

    @Test
    void testNoBadWords() {
        String input = "This is a clean sentence.";
        assertEquals(input, badWordFilter.censorBadWords(input));
    }
}
