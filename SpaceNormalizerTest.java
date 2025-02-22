import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class SpaceNormalizer {
    public String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
}

class SpaceNormalizerTest {
    SpaceNormalizer spaceNormalizer;

    @BeforeEach
    void setUp() {
        spaceNormalizer = new SpaceNormalizer();
    }

    @Test
    void testReplaceMultipleSpaces() {
        String input = "This  is   an  example    with multiple   spaces.";
        String expected = "This is an example with multiple spaces.";
        assertEquals(expected, spaceNormalizer.replaceMultipleSpaces(input));
    }

    @Test
    void testNoExtraSpaces() {
        String input = "This is fine.";
        assertEquals(input, spaceNormalizer.replaceMultipleSpaces(input));
    }
}
