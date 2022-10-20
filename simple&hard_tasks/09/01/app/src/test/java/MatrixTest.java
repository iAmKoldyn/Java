import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    double[][] m = {{1, 2}, {3, 4}};
    double[][] m2 = {{5, 6}, {7, 8}};

    @org.junit.jupiter.api.Test
    void multi() {
        Matrix matrix = new Matrix(m);
        Matrix matrix2 = new Matrix(m2);
        double[][] multi =  matrix.multi(matrix2).getMatrix();
        assertEquals(19, multi[0][0]);
        assertEquals(22, multi[0][1]);
        assertEquals(43, multi[1][0]);
        assertEquals(50, multi[1][1]);
    }

    @org.junit.jupiter.api.Test
    void isNotEmptyTest() {
        Matrix matrix = new Matrix(0, 0);
        Matrix matrix2 = new Matrix(0, 1);
        Matrix matrix3 = new Matrix(1, 1);
        assertFalse(matrix.isNotZero());
        assertFalse(matrix2.isNotZero());
        assertTrue(matrix3.isNotZero());
    }

    @org.junit.jupiter.api.Test
    void isMultiMatrixExpressionTest() {
        Matrix matrix = new Matrix(m);
        Matrix matrix2 = new Matrix(m2);
        assertTrue(matrix.isMultiMatrixExpression(matrix, matrix2));
    }

    @org.junit.jupiter.api.Test
    void sub() {
        Matrix matrix = new Matrix(m);
        Matrix matrix2 = new Matrix(m2);
        double[][] sub =  matrix.sub(matrix2).getMatrix();
        assertEquals(m[0][0] - m2[0][0], sub[0][0]);
        assertEquals(m[0][1] - m2[0][1], sub[0][1]);
        assertEquals(m[1][0] - m2[1][0], sub[1][0]);
        assertEquals(m[1][1] - m2[1][1], sub[1][1]);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Matrix matrix = new Matrix(m);
        Matrix matrix2 = new Matrix(m2);
        double[][] add =  matrix.add(matrix2).getMatrix();
        assertEquals(m[0][0] + m2[0][0], add[0][0]);
        assertEquals(m[0][1] + m2[0][1], add[0][1]);
        assertEquals(m[1][0] + m2[1][0], add[1][0]);
        assertEquals(m[1][1] + m2[1][1], add[1][1]);
    }
}
