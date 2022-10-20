package natural_number_sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalNumberTest {

    @Test
    public void naturalNumberSumWithZero() {
        assertEquals(0, NaturalNumber.getNaturalNumberSum(0));
    }

    @Test
    public void naturalNumberSumWithOne() {
        assertEquals(1, NaturalNumber.getNaturalNumberSum(1));
    }

    @Test
    public void naturalNumberSum() {
        assertEquals(15, NaturalNumber.getNaturalNumberSum(5));
    }
}
