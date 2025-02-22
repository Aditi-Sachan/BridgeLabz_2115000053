import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}

class DateFormatterTest {
    DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    void testValidDateFormat() throws ParseException {
        assertEquals("25-12-2023", dateFormatter.formatDate("2023-12-25"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("25-12-2023"));
    }
}



