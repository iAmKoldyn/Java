package one_line_matrix;

public class OneLineMatrix {
    public static void main(String[] args) {
        int quantity = 10;
        int[][] matrix = new int[quantity][quantity];

        int number = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ++number;
            }
        }

        String matrixString = getMatrixString(matrix);

        System.out.println(matrixString);
    }

    public static String getMatrixString(int[][] matrix) { // Метод для получения строки из значений матрицы
        StringBuilder result = new StringBuilder();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.append(anInt).append(" ");
            }
        }
        return result.toString();
    }
}
