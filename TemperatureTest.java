import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TemperatureConverter {
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

class TemperatureTest {
    TemperatureConverter temperatureConverter;

    @BeforeEach
    void setUp() {
        temperatureConverter = new TemperatureConverter();
    }

    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32, temperatureConverter.celsiusToFahrenheit(0), 0.01);
        assertEquals(212, temperatureConverter.celsiusToFahrenheit(100), 0.01);
    }

    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0, temperatureConverter.fahrenheitToCelsius(32), 0.01);
        assertEquals(100, temperatureConverter.fahrenheitToCelsius(212), 0.01);
    }
}
