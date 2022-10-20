package matrix_multiplication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixHandlerTest {
    @Test
    public void ruleTest() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 1, 2, 3},
                {4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 1, 2, 3}
        };
        long[][] matrix2 = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 1, 2, 3},
                {4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 1, 2, 3},
                {4, 5, 6, 7, 8, 9}
        };
        long[][] finalMatrix = {
                {90, 111, 132, 90, 111, 132},
                {126, 156, 186, 126, 156, 186},
                {162, 201, 240, 162, 201, 240},
                {90, 111, 132, 90, 111, 132},
                {126, 156, 186, 126, 156, 186}
        };

        assertArrayEquals(finalMatrix, matrixHandler.matrixMultiplication(matrix1, matrix2)); // Перемножает

        assertNull(matrixHandler.matrixMultiplication(matrix2, matrix1));                     // Но оборот null
    }


    @Test
    public void MatrixMultiplication() {

        MatrixHandler matrixHandler = new MatrixHandler();

        long[][] matrix_1 = {
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2}
        };

        long[][] matrix_2 = {
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2}
        };

        assertNull(matrixHandler.matrixMultiplication(matrix_1, matrix_2));
    }

    @Test
    public void MatrixMultiplication_2() {

        MatrixHandler matrixHandler = new MatrixHandler();

        long[][] matrix_1 = {
                {1, 5},
                {2, 3},
                {1, 7}
        };

        long[][] matrix_2 = {
                {1, 2, 3, 7},
                {5, 2, 8, 1}
        };

        long[][] matrixResult = matrixHandler.matrixMultiplication(matrix_1, matrix_2);

        long[][] matrixExpected = {
                {26, 12, 43, 12},
                {17, 10, 30, 17},
                {36, 16, 59, 14}
        };

        assertArrayEquals(matrixExpected, matrixResult);
    }

    @Test
    public void matrix() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        long[][] matrix2 = {
                {6, 7},
                {8, 9}
        };
        long[][] finalMatrix = {
                {22, 25},
                {50, 57}
        };
        assertArrayEquals(finalMatrix, matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

    @Test
    public void matrixMultiplyTest_1() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {4, 5, 4, 7, 9},
                {1, 7},
                {8, 6, 2}
        };
        long[][] matrix2 = {
                {2, 3, 5},
                {6, 3, 7}
        };

        assertNull(matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

    @Test
    public void matrixMultiplyTest_2() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {4, 5, 4, 7, 9},
                {1, 7, 4, 1},
                {8, 6, 2},
                {8, 6},
                {8}
        };
        long[][] matrix2 = {
                {2, 3, 5},
                {6, 3, 7}
        };

        assertNull(matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

    @Test
    public void matrixMultiplyTest_3() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        long[][] matrix2 = {
                {1, 2, 3, 4}
        };

        assertNull(matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

    @Test
    public void matrixMultiplyTest() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {
                {4, 5},
                {1, 7},
                {8, 6}
        };
        long[][] matrix2 = {
                {2, 3, 5},
                {6, 3, 7}
        };
        long[][] finalMatrix = {
                {38, 27, 55},
                {44, 24, 54},
                {52, 42, 82}
        };
        assertArrayEquals(finalMatrix, matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

    @Test
    public void matrixErroneousMultiplyTest() {
        MatrixHandler matrixHandler = new MatrixHandler();
        assertNull(matrixHandler.matrixMultiplication(null, null));
    }

    @Test
    public void matrixErroneous2MultiplyTest() {
        MatrixHandler matrixHandler = new MatrixHandler();
        long[][] matrix1 = {{}, {}};
        long[][] matrix2 = {{}, {}};
        assertNull(matrixHandler.matrixMultiplication(matrix1, matrix2));
    }

}
