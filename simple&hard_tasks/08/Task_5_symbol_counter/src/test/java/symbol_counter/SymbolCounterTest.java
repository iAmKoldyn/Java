package symbol_counter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SymbolCounterTest {

    @Test
    public void getSymbolQuantityTest() {
        String text = "I live in a house near the mountains. I have two brothers and one sister, and I was born last. " +
                "My father teaches mathematics, and my mother is a nurse at a big hospital.";
        assertEquals(17, SymbolCounter.getSymbolQuantity(text, 'a'));
    }
}
