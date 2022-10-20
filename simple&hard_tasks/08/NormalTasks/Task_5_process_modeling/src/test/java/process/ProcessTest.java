package process;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProcessTest {

    @Test
    public void countIntersectionTest() {
        assertEquals(1, Process.countIntersection(100, 10));
    }
}
