package JUnit.BasicJUnitProblems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandler {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

public class ExceptionHandlingTesting {
    private final ExceptionHandler exceptionHandler = new ExceptionHandler();

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> exceptionHandler.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    void testValidDivision() {
        assertEquals(5, exceptionHandler.divide(10, 2));
        assertEquals(-3, exceptionHandler.divide(-9, 3));
    }
}