package JUnit.BasicJUnitProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringUtils {
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) return false;
        return str.equalsIgnoreCase(reverse(str));
    }

    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

public class StringUtilityTesting {
    private final StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("", stringUtils.reverse(""));
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertTrue(stringUtils.isPalindrome("racecar"));
        assertTrue(stringUtils.isPalindrome("Madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        assertEquals("WORLD", stringUtils.toUpperCase("world"));
        assertEquals("", stringUtils.toUpperCase(""));
        assertNull(stringUtils.toUpperCase(null));
    }
}