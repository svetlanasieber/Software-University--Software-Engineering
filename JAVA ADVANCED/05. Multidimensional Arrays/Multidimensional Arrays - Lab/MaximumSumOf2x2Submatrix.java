import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOfSubmatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        String dimensions = scanner.nextLine(); 
    
        int rows = Integer.parseInt(dimensions.split(", ")[0]);
        int cols = Integer.parseInt(dimensions.split(", ")[1]);


        int[][] matrix = new int[rows][cols];

  
        fillMatrix(matrix, scanner);

        int maxSum = Integer.MIN_VALUE; 

        int startRow = 0; 
        int startCol = 0;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {

                int sumOfSubmatrix = matrix[row][col] + matrix[row][col + 1] +
                                     matrix[row + 1][col + 1] + matrix[row + 1][col];

                if (sumOfSubmatrix > maxSum) {
                    maxSum = sumOfSubmatrix;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.print(matrix[startRow][startCol] + " ");
        System.out.println(matrix[startRow][startCol + 1] + " ");
        System.out.print(matrix[startRow + 1][startCol] + " ");
        System.out.println(matrix[startRow + 1][startCol + 1]);

        
        System.out.println(maxSum);
    }

   
    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}

