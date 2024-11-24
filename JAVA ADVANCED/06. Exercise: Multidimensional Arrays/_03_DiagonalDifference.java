import java.util.Scanner;

public class _03_DiagonalDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        fillTheMatrix(matrix, scanner);

       
        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);

     
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

      
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {

        int sum = 0;

       
        for (int index = 0; index < matrix.length; index++) {
            int num = matrix[index][index];
            sum += num;
        }

        return sum;
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {

        int sum = 0;

     
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            int num = matrix[row][col];
            sum += num;
            col++;
        }

        return sum;
    }

    private static void fillTheMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
