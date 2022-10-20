  package transposed_matrix;

  // public class Matrix {
  //     public static void main(String[] args) {
  //         int[][] matrix = {
  //                 {1, 2, 3},
  //                 {4, 5, 6}//править
  // 	        };
  //
  //         getTransposedMatrix(matrix);
  //     }
  //
  //     public static void getTransposedMatrix(int[][] matrix) {
  //         for (int i = 0; i < matrix.length+1; i++) {
  //             for (int j = 0; j < matrix[0].length-1; j++) {
  //                 System.out.print(matrix[j][i] + " ");
  //             }
  //             System.out.println();
  //         }
  //     }
  // }


  class Matrix {
    public static void main(String[] args) {
      int[][] matrix = new int[][]{
                    {1, 2, 3, 6},
                    {4, 5, 0, 5},
                    {5, 3, 7, 1}
                };
      for (int i = 0; i < matrix[0].length; i++) {
        for (int j = 0; j < matrix.length; j++) {
          System.out.print(matrix[j][i] + " ");
        }
        System.out.println();
      }
    }
  }
