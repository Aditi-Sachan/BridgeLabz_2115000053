import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class CapitalizedWordExtractor {
    public List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }
}

class CapitalizedWordTest {
    CapitalizedWordExtractor capitalizedWordExtractor;

    @BeforeEach
    void setUp() {
        capitalizedWordExtractor = new CapitalizedWordExtractor();
    }

    @Test
    void testExtractCapitalizedWords() {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> expected = Arrays.asList("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York");
        assertEquals(expected, capitalizedWordExtractor.extractCapitalizedWords(text));
    }

    @Test
    void testNoCapitalizedWords() {
        String text = "this sentence has no capitalized words.";
        assertTrue(capitalizedWordExtractor.extractCapitalizedWords(text).isEmpty());
    }
}
