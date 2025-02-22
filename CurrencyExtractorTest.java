import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class CurrencyExtractor {
    public List<String> extractCurrencyValues(String text) {
        List<String> currencyValues = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }
        return currencyValues;
    }
}

class CurrencyExtractorTest {
    CurrencyExtractor currencyExtractor;

    @BeforeEach
    void setUp() {
        currencyExtractor = new CurrencyExtractor();
    }

    @Test
    void testExtractCurrencyValues() {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> expected = Arrays.asList("$45.99", "10.50");
        assertEquals(expected, currencyExtractor.extractCurrencyValues(text));
    }

    @Test
    void testNoCurrencyValues() {
        String text = "There are no prices mentioned here.";
        assertTrue(currencyExtractor.extractCurrencyValues(text).isEmpty());
    }
}
