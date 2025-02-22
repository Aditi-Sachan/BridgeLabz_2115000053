import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class RepeatingWordFinder {
    public Set<String> findRepeatingWords(String text) {
        Set<String> words = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b").matcher(text);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }
        return repeatedWords;
    }
}

class RepeatingWordFinderTest {
    RepeatingWordFinder repeatingWordFinder;

    @BeforeEach
    void setUp() {
        repeatingWordFinder = new RepeatingWordFinder();
    }

    @Test
    void testFindRepeatingWords() {
        String text = "This is is a repeated repeated word test.";
        Set<String> expected = new HashSet<>(Arrays.asList("is", "repeated"));
        assertEquals(expected, repeatingWordFinder.findRepeatingWords(text));
    }

    @Test
    void testNoRepeatingWords() {
        String text = "Each word appears only once.";
        assertTrue(repeatingWordFinder.findRepeatingWords(text).isEmpty());
    }
}
