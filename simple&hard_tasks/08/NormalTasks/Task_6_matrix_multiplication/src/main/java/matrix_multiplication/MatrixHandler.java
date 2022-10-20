package matrix_multiplication;

import java.util.Random;

public class MatrixHandler {

    public long[][] matrixGeneration(int sizeMatrix) {
        long[][] matrix = new long[sizeMatrix][sizeMatrix];
        Random random = new Random();

        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }
        return matrix;
    }

    public long[][] matrixMultiplication(long[][] matrix_1, long[][] matrix_2) {
        if (matrix_1 == null || matrix_2 == null) return null;

        for (int i = 1; i < matrix_1.length; i++) {
            if (matrix_1[i].length != matrix_1[0].length) return null;
        }

        for (int i = 1; i < matrix_2.length; i++) {
            if (matrix_2[i].length != matrix_2[0].length) return null;
        }

        if (matrix_1[0].length == 0) return null;
        if (matrix_2[0].length == 0) return null;


        long[][] result = new long[matrix_1.length][matrix_2[0].length];//P

        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                long cell = 0;
                for (int i = 0; i < matrix_2.length; i++) {
                    cell += matrix_1[row][i] * matrix_2[i][col];
                }
                result[row][col] = cell;
            }
        }
        return result;
    }

    public void showMatrix(long[][] matrix) {
        for (long[] ints : matrix) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
