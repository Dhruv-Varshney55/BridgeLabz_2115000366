package JUnit.BasicJUnitProblems;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

class PerformanceTester {
    public String longRunningTask() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

public class PerformanceTesting {
    private final PerformanceTester performanceTester = new PerformanceTester();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS)
    void testLongRunningTask() {
        assertEquals("Task Completed", performanceTester.longRunningTask());
    }
}