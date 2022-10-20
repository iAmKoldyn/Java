import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
@Test
    void test() {
    Worker worker = new Worker("Andrew", 100);
    assertEquals(worker, new Worker("Andrew", 100));
}
}