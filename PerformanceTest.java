import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

class PerformanceTester {
    public String longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
        return "Completed";
    }
}

class PerformanceTest {
    PerformanceTester performanceTester = new PerformanceTester();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        assertEquals("Completed", performanceTester.longRunningTask());
    }
}
