package multidimensional_arrays_Lab;

import java.util.Arrays;
import java.util.Scanner;


public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matrixDimension = scanner.nextLine();

        int rows = Integer.parseInt(matrixDimension.split(" ")[0]);
        int cols = Integer.parseInt(matrixDimension.split(" ")[1]);

        int[][] matrix = new int[rows][cols];

        fillMatrix(matrix, scanner);
        
        int number = Integer.parseInt(scanner.nextLine());
        
        boolean isFound = false;
        for (int row = 0; row <= matrix.length -1; row++) {
            for (int col = 0; col <= matrix[0].length -1; col++) {
                int currentElement = matrix[row][col];
                if (currentElement == number) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        
        if (!isFound) {
            System.out.println("not found");
        }
        
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}

