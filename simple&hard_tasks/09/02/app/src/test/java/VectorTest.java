import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    Vector a = new Vector(10, 15);
    Vector b = new Vector(3, 2);

    @Test
    void sub() {
        assertEquals(new Vector(10 -3, 15 - 2), a.sub(b));
    }

    @Test
    void add() {
        assertEquals(new Vector(10 +3, 15 + 2), a.add(b));
    }

    @Test
    void multiScalar() {
        double scalar = 5.0;
        assertEquals(new Vector(10 * scalar, 15 * scalar), a.multiScalar(scalar));
    }

    @Test
    void divideScalar() {
        double scalar = 5.0;
        assertEquals(new Vector(10 / scalar, 15 / scalar), a.divideScalar(scalar));

    }
}