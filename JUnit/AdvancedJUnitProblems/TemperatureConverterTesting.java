package JUnit.AdvancedJUnitProblems;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureConverterTesting {
    private TemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TemperatureConverter();
    }

    @AfterEach
    void tearDown() {
        temperatureConverter = null;
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, temperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212.0, temperatureConverter.celsiusToFahrenheit(100), 0.01);
        assertEquals(98.6, temperatureConverter.celsiusToFahrenheit(37), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, temperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100.0, temperatureConverter.fahrenheitToCelsius(212), 0.01);
        assertEquals(37.0, temperatureConverter.fahrenheitToCelsius(98.6), 0.01);
    }
}