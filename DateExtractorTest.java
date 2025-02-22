import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.*;
import java.util.regex.*;

class DateExtractor {
    public List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}\\b").matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
}

class DateExtractorTest {
    DateExtractor dateExtractor;

    @BeforeEach
    void setUp() {
        dateExtractor = new DateExtractor();
    }

    @Test
    void testExtractDates() {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> expected = Arrays.asList("12/05/2023", "15/08/2024", "29/02/2020");
        assertEquals(expected, dateExtractor.extractDates(text));
    }

    @Test
    void testNoDates() {
        String text = "There are no dates in this sentence.";
        assertTrue(dateExtractor.extractDates(text).isEmpty());
    }
}
