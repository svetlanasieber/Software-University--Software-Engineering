package multidimensional_arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);

        printElementsOnPrimaryDiagonal(matrix);

        System.out.println();

        printElementsOnSecondaryDiagonal(matrix);
    }

    private static void printElementsOnSecondaryDiagonal(int[][] matrix) {

        for (int col = 0; col <= matrix.length - 1; col++) {
            for (int row = 0; row <= matrix[0].length - 1; row++) {
                int currentElement = matrix[row][col];
                if (row + col == matrix.length - 1) {
                    System.out.print(currentElement + " ");
                }
            }
        }
    }

    private static void printElementsOnPrimaryDiagonal(int[][] matrix) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            for (int col = 0; col <= matrix[0].length - 1; col++) {
                int currentElement = matrix[row][col];

                if (row == col) {
                    System.out.print(currentElement + " ");
                }
            }
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}

