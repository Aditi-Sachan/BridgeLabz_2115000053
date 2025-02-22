import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class ProgLangExtractor {
    public List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP)\\b").matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }
}

class ProgLangExtractorTest {
    ProgrammingLanguageExtractor extractor;

    @BeforeEach
    void setUp() {
        extractor = new ProgrammingLanguageExtractor();
    }

    @Test
    void testExtractLanguages() {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = Arrays.asList("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, extractor.extractLanguages(text));
    }

    @Test
    void testNoLanguages() {
        String text = "I love reading books and watching movies.";
        assertTrue(extractor.extractLanguages(text).isEmpty());
    }
}
