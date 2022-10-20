package matrix_multiplication;

import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество матриц: ");
        int quantity = scanner.nextInt();  

        System.out.print("Введите размер матриц: ");
        int sizeMatrix = scanner.nextInt();  

        long[][][] createdMatrix = new long[quantity][sizeMatrix][sizeMatrix];  

        MatrixHandler matrixHandler = new MatrixHandler();

        for (int i = 0; i < quantity; i++) {
            createdMatrix[i] = matrixHandler.matrixGeneration(sizeMatrix);
        }

        long begin = System.currentTimeMillis();


        long[][] matrixResult = createdMatrix[0];//1

        for (int i = 1; i < quantity; i++){
            matrixResult = matrixHandler.matrixMultiplication(matrixResult, createdMatrix[i]);  
        }

        System.out.println((System.currentTimeMillis() - begin) + " milliseconds");

        matrixHandler.showMatrix(matrixResult);
    }
}
