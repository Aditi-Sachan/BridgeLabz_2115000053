import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathOperations {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}

class MathOperationsTest {
    MathOperations mathOperations = new MathOperations();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathOperations.divide(5, 0));
    }
}

