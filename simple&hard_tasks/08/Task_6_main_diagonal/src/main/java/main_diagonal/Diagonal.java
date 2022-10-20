package main_diagonal;

public class Diagonal {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        getMatrixWithMainDiagonal(matrix);
    }

    public static void getMatrixWithMainDiagonal(int[][] matrix) { // Метод вывода матрицы на консоль
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
