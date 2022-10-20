import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {
    @Test
    void test() {
        new Engineer("Andrew", 10).repairPc();
        assertEquals(new Engineer("Andrew", 10), new Engineer("Andrew", 10));
        assertNotEquals(new Engineer("Andrew", 20), new Engineer("Andrew", 10));

    }
}