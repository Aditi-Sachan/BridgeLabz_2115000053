import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

class NumberUtilsTest {
    NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        boolean expected = number % 2 == 0;
        assertEquals(expected, numberUtils.isEven(number));
    }
}
