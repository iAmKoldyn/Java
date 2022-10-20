package generator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberGeneratorTest {
    @Test void workingTime() {
        Generator generate = new Generator(1000, 5000);
        assertEquals(1000, generate.getRandomNumbersArray().length);
    }

    @Test void workingTimeErr() {
        Generator generate = new Generator(1000000, 5);
        assertNull(generate.getRandomNumbersArray());
    }

}
