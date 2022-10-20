import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    private final double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(int n, int m) {
        matrix = new double[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], 0); //k
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

//умножение матрицы
    public Matrix multi(Matrix other) {
        if (!isMultiMatrixExpression(this, other)) {
            throw new IllegalStateException("Матрицы невозможно перемножить из-за неверных размерностей");
        }

        int i, j, k;
        int row1 = this.matrix.length;
        int col1 = this.matrix[0].length;
        int col2 = other.matrix[0].length;
        Matrix multiMatrix = new Matrix(row1, col2);

        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < col1; k++) {
                    multiMatrix.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return multiMatrix;
    }

    public boolean isNotZero() {
        if (matrix.length == 0) {
            return false;
        }

        for (double[] doubles : matrix) {
            if (doubles.length == 0) {
                return false; //String
            }
        }

        return true;
    }

//проверяет две матрицы на возможность перемножения с>строк
    public boolean isMultiMatrixExpression(Matrix o1, Matrix o2) {
        if (!o1.isNotZero() || !o2.isNotZero()) {
            return false;
        }
        int col = o1.matrix[0].length;
        int row = o2.matrix.length;
        if (col != row) {
            return false;
        }
        for (int i = 0; i < o1.matrix.length; i++) {
            if (o1.matrix[i].length != col) {
                return false;
            }
        }
        return true;
    }

    public Matrix sub(Matrix other) {
        if (!isNotZero() || !other.isNotZero()) {
            throw new IllegalStateException("В матрицы обнаружились нулевые столбцы/строки");
        }

        if (other.matrix.length != this.matrix.length || other.matrix[0].length != this.matrix[0].length) {
            throw new IllegalStateException("Матрицы разных размеров");
        }

        Matrix subMatrix = new Matrix(this.matrix.length, this.matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                subMatrix.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return subMatrix;
    }

    public Matrix add(Matrix other) {
        if (!isNotZero() || !other.isNotZero()) {
            throw new IllegalStateException("В матрицы обнаружились нулевые столбцы/строки");
        }

        if (other.matrix.length != this.matrix.length || other.matrix[0].length != this.matrix[0].length) {
            throw new IllegalStateException("Матрицы разных размеров");
        }

        Matrix addMatrix = new Matrix(this.matrix.length, this.matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                addMatrix.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return addMatrix;
    }

    public void input(Scanner in) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
    }
//Печать матриц
    public void show() {
        System.out.println(this);
    }
//toString
    @Override
    public String toString() {
        StringBuilder myMatrix = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                myMatrix.append(matrix[i][j]).append(" ");
            }
            if (i + 1 < this.matrix.length) {
                myMatrix.append("\n");
            }
        }
        return myMatrix.toString();
    }
}
