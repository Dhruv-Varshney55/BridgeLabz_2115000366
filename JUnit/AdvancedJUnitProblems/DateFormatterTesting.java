package JUnit.AdvancedJUnitProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        inputFormat.setLenient(false);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}

public class DateFormatterTesting {
    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    @AfterEach
    void tearDown() {
        dateFormatter = null;
    }

    @Test
    void testValidDateFormatting() throws ParseException {
        assertEquals("25-02-2025", dateFormatter.formatDate("2025-02-25"));
        assertEquals("01-01-2000", dateFormatter.formatDate("2000-01-01"));
        assertEquals("15-08-1947", dateFormatter.formatDate("1947-08-15"));
    }

    @Test
    void testInvalidDateFormatting() {
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("25-02-2025"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("invalid-date"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("2025/02/25"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("2025-13-01"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("2025-02-30"));
    }
}