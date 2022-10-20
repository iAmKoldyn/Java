package factorial;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {
    @Test
    public void testFactorial(){
        assertEquals(new BigInteger("33452526613163807108170062053440751665152000000000"), Factorial.getFactorial(41));
    }

    @Test
    public void testRecursiveFactorial(){
        assertEquals(new BigInteger("20397882081197443358640281739902897356800000000"), RecursiveFactorial.getFactorial(1024));
    }
}
