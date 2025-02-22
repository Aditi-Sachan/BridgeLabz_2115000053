import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }


    public String toUpperCase(String str) {
        return str.toUpperCase();
    }
}


class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();


    @Test
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
    }


    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }


    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}
