package multidimensional_arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split(", ")[0]);
        int cols = Integer.parseInt(dimensions.split(", ")[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);

        int sum = getSumMatrixElements(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int getSumMatrixElements(int[][] matrix) {
        int sum = 0; 

        for (int row = 0; row <= matrix.length -1 ; row++) {
            for (int col = 0; col <= matrix[0].length -1 ; col++) {
                int currentElement = matrix[row][col];
                sum += currentElement;
            }
        }

        return sum;

    }
}
