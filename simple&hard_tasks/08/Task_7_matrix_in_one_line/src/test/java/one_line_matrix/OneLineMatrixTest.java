package one_line_matrix;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OneLineMatrixTest {

    @Test
    public void getMatrixStringTest() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        assertEquals("1 2 3 4 5 6 7 8 9 ", OneLineMatrix.getMatrixString(matrix));
    }
}
