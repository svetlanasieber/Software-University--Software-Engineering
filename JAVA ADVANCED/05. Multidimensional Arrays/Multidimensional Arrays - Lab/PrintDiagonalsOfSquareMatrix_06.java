import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        fillMatrix(matrix, scanner);

       
        printPrimaryDiagonal(matrix);
        System.out.println();
  
        printSecondaryDiagonal(matrix);
    }

    private static void printSecondaryDiagonal(int[][] matrix) {
        int col = 0;
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            System.out.print(matrix[row][col] + " ");
            col++;
        }
    }

    private static void printPrimaryDiagonal(int[][] matrix) {
      for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}

